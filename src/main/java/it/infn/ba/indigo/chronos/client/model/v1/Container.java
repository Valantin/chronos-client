package it.infn.ba.indigo.chronos.client.model.v1;

import java.util.Collection;

import it.infn.ba.indigo.chronos.client.utils.ModelUtils;

public class Container {
	private String type;
	private String image;
	private Boolean forcePullImage;
	private String network;
	private Collection<Volume> volumes;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean isForcePullImage() {
		return forcePullImage;
	}

	public void setForcePullImage(Boolean forcePullImage) {
		this.forcePullImage = forcePullImage;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public Collection<Volume> getVolumes() {
		return volumes;
	}

	public void setVolumes(Collection<Volume> volumes) {
		this.volumes = volumes;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
