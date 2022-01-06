import io.javalin.Javalin;
import pojo.LaptopPojo;
import pojo.ReimbursementPojo;

import service.LaptopService;
import service.LaptopServiceImpl;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;

public class LaptopCrudMain {

	public static void main(String[] args) {

		LaptopService laptopService = new LaptopServiceImpl();
    	ReimbursementService reimbursementService = new ReimbursementServiceImpl();

		Javalin server = Javalin.create((config) -> config.enableCorsForAllOrigins()).start(4040);

		// http://localhost:4040/hello

		server.get("hello", (ctx) -> {

			// tell here what to do when the hello endpoint is requested for
			System.out.println("Hello endpoint is requested!!");
			ctx.result("Hello endpoint is requested!!");

		});

		// get endpoint to fetch all the laptops
		// http://localhost:4040/api/laptops
		server.get("api/laptops", (ctx) -> {
			ctx.json(laptopService.getAllLaptops());
			// System.out.println("get all laptops!!!");
		});
			// get endpoint to fetch all the reimbursements
			// http://localhost:4040/api/reimbursements
	server.get("api/reimbursements", (ctx) -> {
	ctx.json(reimbursementService.getAllReimbursements());
			 System.out.println("get all reimbursements!!!");

		});

		// get endpoint to fetch one laptop
		// http://localhost:4040/api/laptops/5
		// 5 is a pathParam and they are given in a {}
		server.get("api/laptops/{bid}", (ctx) -> {
			ctx.json(laptopService.getALaptop(Integer.parseInt(ctx.pathParam("bid"))));
		});	
			
			
		// get endpoint to fetch one reimbursement
		// http://localhost:4040/api/reimbursements/5
		// 5 is a pathParam and they are given in a {}
		server.get("api/reimbursements/{bid}", (ctx) -> {
			ctx.json(reimbursementService.getAReimbursement(Integer.parseInt(ctx.pathParam("bid"))));				

		});

		// delete endpoint to delete one laptop
		// http://localhost:4040/api/laptops/5
		server.delete("api/laptops/{bid}", (ctx) -> {
			laptopService.deleteLaptop(Integer.parseInt(ctx.pathParam("bid")));
		});
			
		// delete endpoint to delete one reimbursement
		// http://localhost:4040/api/reimbursements/5
		server.delete("api/reimbursements/{bid}", (ctx) -> {
			reimbursementService.deleteReimbursement(Integer.parseInt(ctx.pathParam("bid")));	
						
		});

		// post endpoint to add a laptop
		// http://localhost:4040/api/laptops
		server.post("api/laptops", (ctx) -> {
			LaptopPojo returnLaptopPojo = laptopService.addLaptop(ctx.bodyAsClass(LaptopPojo.class));
			ctx.json(returnLaptopPojo);
		});
		
		// post endpoint to add a reimbursement
		// http://localhost:4040/api/reimbursements
		server.post("api/reimbursements", (ctx) -> {
			ReimbursementPojo returnReimbursementPojo = reimbursementService.addReimbursement(ctx.bodyAsClass(ReimbursementPojo.class));
			ctx.json(returnReimbursementPojo);
		});
		
		

		// put endpoint to update a laptop
		// http://localhost:4040/api/laptops
		server.put("api/laptops/{bid}", (ctx) -> {
			LaptopPojo returnLaptopPojo = laptopService.updateLaptop(ctx.bodyAsClass(LaptopPojo.class));
			ctx.json(returnLaptopPojo);

		});
		
		// put endpoint to update a reimbursement
		// http://localhost:4040/api/reimbursements
		server.put("api/reimbursements/{bid}", (ctx) -> {
			ReimbursementPojo returnReimbursementPojo = reimbursementService.updateReimbursement(ctx.bodyAsClass(ReimbursementPojo.class));
			ctx.json(returnReimbursementPojo);

		});

	}

}