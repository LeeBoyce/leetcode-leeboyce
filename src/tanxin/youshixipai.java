package tanxin;

import java.util.*;

/**
 * @author jianw.li
 * @date 2018/12/17 11:54 PM
 * @Description: TODO
 */
public class youshixipai {
    public int[] advantageCount(int[] A, int[] B) {
        //排序
        int[] sortA = A.clone();
        Arrays.sort(sortA);
        int[] sortB = B.clone();
        Arrays.sort(sortB);

        //找位置
        Map<Integer, Queue<Integer>> signMap = new HashMap();
        for(int b : B){
            signMap.put(b, new LinkedList());
        }
        ArrayList<Integer> unsignArray = new ArrayList();

        int j = 0;
        for(int a : sortA){
            //如果a<b,则b继续等下一个a,直到a>b
            if(a > sortB[j]){
                signMap.get(sortB[j++]).offer(a);
            }else{
                unsignArray.add(a);
            }
        }

        //重新还原
        int[] reconB = new int[B.length];
        int arrayIndex = 0;
        int reconBIndex = 0;
        for(int b: B){
            if(signMap.containsKey(b)  &&  signMap.get(b).size() > 0){
                reconB[reconBIndex++] = signMap.get(b).poll();
            }else{
                reconB[reconBIndex++] = unsignArray.get(arrayIndex++);
            }
        }
        return reconB;
    }
}
