package com.SwissKnife;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

public class Utils {
	String fileType;
	String source;
	String destination;

	public Utils() {
		super();
	}

	public Utils(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
	}

	
	public void secureDelete(File file) throws IOException {
	    if (file.exists()) {
	        long length = file.length();
	        SecureRandom random = new SecureRandom();
	        RandomAccessFile raf = new RandomAccessFile(file, "rws");
	        raf.seek(0);
	        raf.getFilePointer();
	        byte[] data = new byte[64];
	        int pos = 0;
	        while (pos < length) {
	            random.nextBytes(data);
	            raf.write(data);
	            pos += data.length;
	        }
	        raf.close();
	        file.delete();
	    }
	}
	
	@SuppressWarnings("unused")
	public void delete(File file) throws IOException {
		// deleter
		for (File childFile : file.listFiles()) {

			if (childFile.isDirectory()) {
				delete(childFile);
			} else {
				if (!childFile.delete()) {
					throw new IOException();
				}
			}
		}

		if (!file.delete()) {
			throw new IOException();
		}
	}

	public void FolderMoveR(String source, String destination) throws IOException {
		// file/folder mover
		this.source = source;
		this.destination = destination;
		Path temp = Files.move(Paths.get(source), Paths.get(destination));

		if (temp != null) {
			System.out.println("File renamed and moved successfully");
		} else {
			System.out.println("Failed to move the file");
		}
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	// identify filetypes
	public String identifyFileTypeUsingFilesProbeContentType(final String fileName) {
		String fileType = "Undetermined";
		final File file = new File(fileName);
		try {
			fileType = Files.probeContentType(file.toPath());
		} catch (IOException ioException) {
			System.out.println(
					"ERROR: Unable to determine file type for " + fileName + " due to exception " + ioException);
		}
		return fileType;
	}
}
