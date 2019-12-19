package guru.springframework.blog.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

@XmlRootElement(name = "product")
	@XmlAccessorType(XmlAccessType.FIELD)
	public class Product {
	    @XmlAttribute(name = "id")
	    private String productId;
	    @XmlElement(name = "description")
	    private String description;
	    @XmlElement(name = "imageUrl")
	    private String imageUrl;
	    @XmlElement(name = "price")
	    private BigDecimal price;
	    @XmlElement(name = "createdBy")
	    private User createdBy;
	    @XmlElement(required = true ,nillable = false)
	    private List<Item> item;
	    
	    public Product(){}
	    public Product(String productId, String description, String imageUrl,
	                   BigDecimal price, User createdBy,List<Item> item) {
	        this.productId = productId;
	        this.description = description;
	        this.imageUrl = imageUrl;
	        this.price = price;
	        this.createdBy = createdBy;
	        this.item = item;
	    }
	    @Override
	    public String toString() {
	        return "Product{" +
	                "\n productId='" + productId + '\'' +
	                ",\n description='" + description + '\'' +
	                ",\n imageUrl='" + imageUrl + '\'' +
	                ",\n price=" + price +
	                 ",\n item=" + item +
	                ",\n createdBy=" + createdBy +"\n"+
	                '}';
	    }
		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public User getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(User createdBy) {
			this.createdBy = createdBy;
		}
		public List<Item> getItem() {
			return item;
		}
		public void setItem(List<Item> item) {
			this.item = item;
		}
	    
	    
	    
}
