void main(){
    int num = (new java.util.Random()).nextInt(900) + 100;
    int sumDigit = num % 10 + (num / 10) % 10 + (num / 100) % 10;
    System.out.println("число: " + num + "\n" + "сумма цифр: " + sumDigit);
}
