package service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import model.BusDriver;

public class BusDriverDaoImpl implements BusDriverDao{

	@Override
	public boolean addBusDriver(BusDriver driver) {
		
		try {
            Connection conn = new DBConnection().DBConnection();
            String sql = "insert into busdriver(name,licenceno,emailid,phoneno,travelsagency,licphotof,licphotob,healthcert) values (?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenceNo()); 
            statement.setString(3, driver.getEmailid()); 
            statement.setString(4, driver.getPhoneno()); 
            statement.setString(5, driver.getTravelsAgency()); 
            statement.setBytes(6, driver.getLicencePhotofront());
            statement.setBytes(7, driver.getLicencePhotoback()); 
            statement.setBytes(8, driver.getHealthCertificate()); 

            int row = statement.executeUpdate();
            if (row > 0) {
               return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public BusDriver getBusDriver(String attribute, String value) {
		
		BusDriver driver = new BusDriver();
		
		try {
			Connection conn = new DBConnection().DBConnection();
			Statement st = conn.createStatement();
			String query = "select * from busdriver where "+attribute+"=\""+value+"\";";
			System.out.println(query);
			ResultSet rt = st.executeQuery(query);
			rt.next();
			driver.setName(rt.getString(1));
			driver.setLicenceNo(rt.getString(2));
			driver.setEmailid(rt.getString(3));
			driver.setPhoneno(rt.getString(4));
			driver.setTravelsAgency(rt.getString(5));
			
			Blob blobf = rt.getBlob(6);
			Blob blobb = rt.getBlob(7);
			
            InputStream inputStreamf = blobf.getBinaryStream();
            InputStream inputStreamb = blobb.getBinaryStream();
            ByteArrayOutputStream outputStreamf = new ByteArrayOutputStream();
            ByteArrayOutputStream outputStreamb = new ByteArrayOutputStream();
            byte[] bufferf = new byte[4096];
            byte[] bufferb = new byte[4096];
            int bytesReadf = -1;
            int bytesReadb = -1;
             
            while ((bytesReadf = inputStreamf.read(bufferf)) != -1) {
                outputStreamf.write(bufferf, 0, bytesReadf);                  
            }
            while ((bytesReadb = inputStreamb.read(bufferb)) != -1) {
                outputStreamb.write(bufferb, 0, bytesReadb);                  
            }
             
            byte[] imageBytesf = outputStreamf.toByteArray();
            byte[] imageBytesb = outputStreamb.toByteArray();
           
            driver.setLicencePhotofrontDB(Base64.getEncoder().encodeToString(imageBytesf));
            driver.setLicencePhotobackDB(Base64.getEncoder().encodeToString(imageBytesb));
            
            inputStreamf.close();
            inputStreamb.close();
            outputStreamf.close();
            outputStreamb.close();
            
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return driver;
	}

	@Override
	public byte[] PdfFromDatabase(String licenceno) {
		
		try {
			Connection con = new DBConnection().DBConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select healthcert from busdriver where licenceno=\""+licenceno+"\";");
			int i=1;
			InputStream in = null;
			while(rs.next()) {
				in = rs.getBinaryStream(1);
			}
			int available1 = in.available();
			byte[] bt = new byte[available1];
			in.read(bt);

			return bt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
