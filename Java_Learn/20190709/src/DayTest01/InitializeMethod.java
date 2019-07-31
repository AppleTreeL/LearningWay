package DayTest01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname InitializeMethod
 * @Description TODO
 * @Date 2019/7/31 11:36
 * @Created by AppleTree
 */

class Person{
    public String name;
    public int voteNum;

    public Person(String name){
        this.name = name;
        this.voteNum = 0;
    }
}

public class InitializeMethod {

    public List<Person> personList;

    public InitializeMethod() {
        this.personList = new ArrayList<>();
    }

    public int AddCandidate(String pCandidateName){
        if(pCandidateName != null){
            Person person = new Person(pCandidateName);
            personList.add(person);
            return 1;
        }else {
            return 0;
        }
    }

    public void vote(String pCandidateName){
        for (int i = 0; i < personList.size(); i++) {
            if(personList.get(i).name.equals(pCandidateName)){
                personList.get(i).voteNum += 1;
            }
        }
    }

    public int GetVoteResult(String pCandidateName) {
        if(pCandidateName == null){
            return  -1;
        }else {
            for (int i = 0; i < personList.size(); i++) {
                if(personList.get(i).name.equals(pCandidateName)) {
                    return personList.get(i).voteNum;
                }
            }
            return -1;
        }
    }

    public void clear(){
        for (int i = 0; i < personList.size(); i++) {
            personList.get(i).voteNum = 0;
        }
        personList = null;
    }

    public static void main(String[] args) {
        InitializeMethod vote = new InitializeMethod();
        Scanner in = new Scanner(System.in);
        int personNum = in.nextInt();
        String[] nameArray = new String[personNum];
        for (int i = 0; i < nameArray.length; i++) {
            nameArray[i] = in.next();
        }
        for (int i = 0; i < nameArray.length; i++) {
            vote.AddCandidate(nameArray[i]);
        }
        int chooseNum = in.nextInt();
        String[] chooseArray = new String[chooseNum];
        for (int i = 0; i < chooseArray.length; i++) {
            chooseArray[i] = in.next();
        }
        for (int i = 0; i < chooseArray.length; i++) {
            vote.vote(chooseArray[i]);
        }

        int sumVote = 0;
        for (int i = 0; i < vote.personList.size(); i++) {
            sumVote += vote.personList.get(i).voteNum;
            System.out.println(vote.personList.get(i).name+" "+vote.personList.get(i).voteNum);
        }
        System.out.println("Invalid"+" "+sumVote);
    }

}
