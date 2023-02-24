public class ValueNode extends Node {
  private String value;
  private Double value_double;
  private Boolean value_bool;

  public ValueNode() 
  {
      this.value = null;
  }
  public ValueNode(double value) 
  {
      this.value_double = value;
  }
  public ValueNode(boolean value) 
  {
      this.value_bool = value;
  }
  public ValueNode(String value) 
  {
      this.value = value;
  }
  public boolean isNumber() 
  {
      return value_double != null;
  }
  public boolean isBoolean() 
  {
      return value_bool != null;
  } 
  public boolean isString() 
  {
      return value != null;     
  } 
  public boolean isNull() 
  {
      return value == null;
  }
  public Object getNull () 
  {
      return null;
  }
  public double getNumber() 
  {
      return value_double;
  }
  public boolean getBoolean() 
  {
      return value_bool;
  }
  public String getString() 
  {
      return value;
  }
}