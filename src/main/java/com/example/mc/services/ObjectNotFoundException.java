package com.example.mc.services;

public class ObjectNotFoundException extends RuntimeException{

		private static final long serialVersionUID = 1L;

		public ObjectNotFoundException(String msg) {
			super(msg);
			// TODO Auto-generated constructor stub
		}
		
		public ObjectNotFoundException(String msg,  Throwable cause) {
			super(msg, cause);
		}

}
