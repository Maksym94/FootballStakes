package systemServices;

import java.io.File;

public class FileUploadPath {
	private String temporaryUploadDirectory;
	private String uploadDirectory;
	
	public String getTemporaryUploadDirectory() {
		return temporaryUploadDirectory;
	}
	public void setTemporaryUploadDirectory(String temporaryUploadDirectory) {
		this.temporaryUploadDirectory = temporaryUploadDirectory;
	}
	public String getUploadDirectory() {
		return uploadDirectory;
	}
	public void setUploadDirectory(String uploadDirectory) {
		this.uploadDirectory = uploadDirectory;
	}

	public static void main(String[] args) {
		File file = new File("/webapp/footballStakes/uploads/user/defaultUser.jpg");
		System.out.println(file.getAbsolutePath());
	}

}
