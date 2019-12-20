package guru.springframework.blog.xml;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import guru.springframework.blog.domain.Item;
import guru.springframework.blog.domain.Product;

public class ProductToXmlTest {
	
	 	private Product product;
	 	
	    @Before
	    public void setUp() {
	        long l = 11; 
	        ArrayList<Item> listItem = new ArrayList<>();
	        listItem.add(new Item());
	        product = new Product("PO1", "Spring Guru Mug", "1", new BigDecimal(18.95), null,listItem);
	    }
	    @After
	    public void tearDown() {
	        product = null;
	    }
	    @Test
	    public void testObjectToXml() throws JAXBException, FileNotFoundException {
	        JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
	        Marshaller marshaller = jaxbContext.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        marshaller.marshal(product, new File("product.xml"));
	        marshaller.marshal(product, System.out);
	    }
	    
	    
	    @Test
	    public void testXmlToObject() throws JAXBException, FileNotFoundException {
	        File file = new File("product.xml");
	        JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
	        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	        product = (Product) unmarshaller.unmarshal(file);
	        System.out.println(product);
	        assertTrue(product.getItem().size()==0);
	        
	    }
}
