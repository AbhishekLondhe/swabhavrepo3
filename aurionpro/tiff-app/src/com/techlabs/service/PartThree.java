package com.techlabs.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.awt.image.RenderedImage;
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.media.jai.codec.SeekableStream;
import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.ImageCodec;

public class PartThree {
	public static void main(String[] args) {
//		System.out.println("before imagepath");
//	    String imagePath = "C:/Users/DELL/Desktop/base64/image.jpg";
//	    System.out.println("after imagepath");
//	    System.out.println("=================Encoder Image to Base 64!=================");
//	    String base64ImageString = encoder(imagePath);
//	    System.out.println("base64ImageString before");
//	    System.out.println("Base64ImageString = " + base64ImageString);
	 
	    System.out.println("=================Before Base64 to TIFF=================");
	    String tiffString="";
	    decoder(tiffString, "C:/Users/DELL/Desktop/base64/decoderimage.tif");	 
	    System.out.println("=================After Base64 to TIFF=================");
	    
	//    TiffToJpg("C:/Users/DELL/Desktop/base64/decoderimage.tif","C:/Users/DELL/Desktop/base64/decoderimage.jpg");
	  }
	 
	  public static String encoder(String imagePath) {
	    String base64Image = "";
	    File file = new File(imagePath);
	    try (FileInputStream imageInFile = new FileInputStream(file)) {
	      // Reading a Image file from file system
	      byte imageData[] = new byte[(int) file.length()];
	      imageInFile.read(imageData);
	      base64Image = Base64.getEncoder().encodeToString(imageData);
	    } catch (FileNotFoundException e) {
	      System.out.println("Image not found" + e);
	    } catch (IOException ioe) {
	      System.out.println("Exception while reading the Image " + ioe);
	    }
	    return base64Image;
	  }
	 
	  public static void decoder(String base64Image, String pathFile) {
	    try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
	      // Converting a Base64 String into Image byte array
	      byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
	      imageOutFile.write(imageByteArray);
	    } catch (FileNotFoundException e) {
	      System.out.println("Image not found" + e);
	    } catch (IOException ioe) {
	      System.out.println("Exception while reading the Image " + ioe);
	    }
	  }
//	  public static void TiffToJpg(String tiff, String output)
//			     throws IOException
//			  {
//			    File tiffFile = new File(tiff);
//			    SeekableStream s = new FileSeekableStream(tiffFile);
//			    TIFFDecodeParam param = null;
//			    ImageDecoder dec = ImageCodec.createImageDecoder("tiff", s, param);
//			    RenderedImage op = dec.decodeAsRenderedImage(0);
//			    FileOutputStream fos = new FileOutputStream(output);
//			    JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(fos);
//			    jpeg.encode(op.getData());
//			    fos.close();
//			  }

}