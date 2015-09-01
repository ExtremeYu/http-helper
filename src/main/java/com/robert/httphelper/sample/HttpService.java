package com.robert.httphelper.sample;

// @RestUrl(url = "http://localhost:8080/student")
public interface HttpService {
	// @Get
	public @Json2Object Student getStudent(@QueryParam long dogId);
	
	// @Post
	public @Json2Status int getStudent(@FormField long dogId);

}
