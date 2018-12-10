package com.example.bibased.excelutil;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import java.io.Serializable;
//import org.apache.commons.lang.builder.EqualsBuilder;
//import org.apache.commons.lang.builder.HashCodeBuilder;
//import org.apache.commons.lang.builder.ToStringBuilder;
//import org.apache.commons.lang.builder.ToStringStyle;

public class BaseObject implements Serializable{
      private static final long serialVersionUID = 2820441983839220195L;

      public BaseObject() {}

      public boolean equals(Object other)
      {
           return EqualsBuilder.reflectionEquals(this, other);
       }

      public int hashCode()
      {
          return HashCodeBuilder.reflectionHashCode(this);
       }

      public String toString()
      {
          return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
      }

}
