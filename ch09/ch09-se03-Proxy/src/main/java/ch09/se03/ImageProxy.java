package ch09.se03;

public class ImageProxy implements Image {
	private Image image;
	
	public ImageProxy(Image image) {
		this.image = image;
	}

	@Override
	public void show() {
		if(image == null) {
			image = new BigImage();
		}
		
		image.show();
	}
	
}
