package ch08.se03.domain;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class TestBean implements ResourceLoaderAware {
	
	private ResourceLoader rd;

	// 注册一个实现了ResourceLoaderAware接口的Bean到Spring容器中时，Spring会自动调用setResourceLoader方法，并将自身作为参数传入
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.rd = resourceLoader;
	}

	public ResourceLoader getRd() {
		return rd;
	}

	public void setRd(ResourceLoader rd) {
		this.rd = rd;
	}

}
