package beta;

import java.io.File;

public class Music {

	private String path;

    public Music(String path) {
        this.path = path;
    }

    
    
    
    
    
    public String getPath() {
        
        File file = new File(path);
        if (file.exists()) {
            return path;
        } else {
           
            throw new IllegalArgumentException("File not found: " + path);
        }
    }



	
}
