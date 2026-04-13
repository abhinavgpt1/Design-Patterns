class MyClassMyIterator implements MyIterator {

    MyClass myClass;
    int index = 0;
    MyClassMyIterator(MyClass myClass) {
        this.myClass = myClass;
    }
    @Override
    public boolean hasNext() {
        return index < myClass.getSize();
    }

    @Override
    public String next() {
        if(index >= myClass.getSize()) {
            throw new IndexOutOfBoundsException("No more elements");
        }
        return myClass.getItem(index++);
    }
    
}