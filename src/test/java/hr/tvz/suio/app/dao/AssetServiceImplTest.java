package hr.tvz.suio.app.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import hr.tvz.suio.app.model.Asset;

@SpringBootTest
@AutoConfigureMockMvc
class AssetServiceImplTest {

	MockMvc mock;
	AssetServiceImpl assetService = new AssetServiceImpl();
	@Test
	void testGetAll() throws Exception {

		
	}


}
