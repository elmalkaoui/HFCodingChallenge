# HFCodingChallenge
Implemented libraries:
	- Retrofit 2 : i choosed It because that makes it relatively easy to retrieve and upload JSON via a REST based web service.
	To work with Retrofit you need basically :model class which is used to map the JSON data to, 
	interfaces which defines the possible HTTP operations and 
	Retrofit.Builder  which uses the interface and the Builder API which allows defining the URL end point for the HTTP operation.
	- Picasso : is used for downloading Repository owner avatr, it is easy to use and has unbelievable features, in our case it is recommended to use it
		After implemented it in grade file, we can just call Picasso to load the avatar like:
			Picasso.with(context).load(avatar_url).into(imageView);
