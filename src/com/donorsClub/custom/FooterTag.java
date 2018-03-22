package com.donorsClub.custom;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * @since 3/19/2018
 * @author Mafrel
 */
public class FooterTag extends SimpleTagSupport{
  private String align;
  private String text;
  
  public String getAlign() {
    return align;
  }

  public void setAlign(String align) {
    this.align = align;
  }
  
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void doTag() throws JspException, IOException{
    
    JspWriter out = getJspContext().getOut();
    out.println(String.format("<span style='text-align:%s'>%s</span>", align, text));
  }
  
}
