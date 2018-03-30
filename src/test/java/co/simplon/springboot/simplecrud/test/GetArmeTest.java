package co.simplon.springboot.simplecrud.test;

import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

import co.simplon.springboot.simplecrud.service.ArmeService;
import co.simplon.springboot.simplecrud.service.impl.ArmeServiceImpl;

@RunWith(SpringRunner.class)
//@WebMvcTest(value = ArmeController.class, secure= false)
public class GetArmeTest {
	
  /*  @Autowired
    private MockMvc mockMvc;

@MockBean
private ArmeService armeService;
*/        
    //Test d'un get de Arme par Id

    @Test
    public void ArmeTest() throws Exception {
    	
    	ArmeService armeService = new ArmeServiceImpl();
    	
    	assertFalse(armeService.getAllArmes().isEmpty());
    	
    	
    }
	
	
	
}
