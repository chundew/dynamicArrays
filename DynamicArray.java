public class DynamicArray <T>
{
private Object[] elements;
private int size;
private int capacity;
private final double expansionThreshold = 0.85;
private final double reductionThreshold = 0.35;

DynamicArray ()
{
    this(10);
}
DynamicArray (int capacity)
{
    this.capacity=capacity;
    this.size=0;
    this.elements=new Object[capacity];
}
DynamicArray (T[] elements)
{
    this.size = elements.length;
    this.elements = new Object[10];
    this.capacity = 10;
    while (((double)this.size/this.capacity) >= expansionThreshold)
    {
        this.resize(this.capacity*2);
    }
    for (int i = 0; i< this.size; i+= 1)
    {
        this.elements[i]= (Object) elements[i];
    }
}
/**put at index**/

void put(int index, T element) //or replace
{
    if(index<this.size && (index>0))
    {
        this.elements [index] = element;
    }
}
/**add at the end**/

void append ( T element)
/**Subtraction**/
{
    this.elements[size]=element;
    this.size+=1;
    this.checkresize();
}

T remove (int index)
/**get at index**/
{
    if(index<this.size && (index>0))
    {
        T temp = (T) this.elements[index];
        this.shiftUp(index);
        return temp;
    }
    return null;
}
T get (int index)
{
    if(index<this.size && (index>0))
    {
        T temp = (T) this.elements[index];
        return temp;
    }
    return null;
}

/**Resize the array**/
void checkresize()
{
   double ratio = ((double)this.size)/this.capacity;
   if((ratio < reductionThreshold) && (this.capacity <= 10))
   {
       this.resize(this.capacity/2 );
   }
   if(ratio > expansionThreshold)
   {
       this.resize(this.capacity*2);
   }
}
private void resize (int newSize)
/**Resize the array**/
{
    Object[] temp = new Object[newSize];
    for(int i=0; i<size;i+=1)
    {
        temp[i]=this.elements[i];
    }
    this.capacity=newSize;
    this.elements=temp;
}
private void shiftUp (int index)
/**returns the current size**/
{
    for(int i=index; i<this.size;i+=1)
    {
        this.elements[i]=this.elements[i+1];
    }
}
int size ()
/**check if the dynamic array is empty**/
{
    return this.size;
}
boolean isEmpty ()
/**Object defined methods**/
{
    return this.size==0;
}
public Object clone() 
{
    return (Object) new DynamicArray(this.elements);
}
public String toString()
{
    String result = "";
    for(int i=0; i<this.size;i+=1)
    {
        result += this.elements[i].toString();
    }
    return result;
}
}