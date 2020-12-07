package com.mymc.reflection;

public class Hero {

    public Hero() {
    }
}


class APHero extends Hero {

    public void magicAttack() {
        System.out.println("进行魔法攻击");
    }

    public APHero() {
    }
}

class ADHero extends Hero {

    public void physicAttack() {
        System.out.println("进行物理攻击");
    }

    public ADHero() {
    }
}