package pl.vistula.model;

public class ConvertFileRequest {
    private String sourceFile;
    private String destinationFile;
    private String fileFormat;

    public ConvertFileRequest() {
    }

    public ConvertFileRequest(String sourceFile, String destinationFile, String fileFormat) {
        this.sourceFile = sourceFile;
        this.destinationFile = destinationFile;
        this.fileFormat = fileFormat;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getDestinationFile() {
        return destinationFile;
    }

    public void setDestinationFile(String destinationFile) {
        this.destinationFile = destinationFile;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }
}
