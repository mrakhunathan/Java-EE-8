/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.imaginovation.ee8.beans;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Rakhunathan <rakhun@imaginovation.net>
 */
@Named
@ViewScoped
@Getter
@Setter
@NoArgsConstructor
public class MyBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String myTf;
	private Date thisDate;

	@PostConstruct
	public void initBean() {
		myTf = "Sample";
	}

	public void printMyValue() {
		System.out.println("MyTf = " + myTf);
	}
}
