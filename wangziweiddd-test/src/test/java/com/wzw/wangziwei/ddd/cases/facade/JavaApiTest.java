package com.wzw.wangziwei.ddd.cases.facade;

import org.apache.commons.compress.utils.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaApiTest {
    @Test
    public void Test001() throws ParseException {
        //高级语言就是封装好了一个个基础功能，通过这些基础功能的聚合就可以实现无穷的功能
        //基本数据类型和包装类型的装箱与拆箱
        //八种基本数据类型
        int i = 65535;
        boolean b = false;
        char c = '1';
        char cc = 65535;
        Assert.assertEquals(i, cc);
        byte by = -128;
        short s = 32767;
        long l = 999999999l;
        float f = 65535f;
        double d = 65535d;
        //基本数据类型一般存储在栈帧或元空间中且必须赋一个初值
        //有这些基本的变量配合条件、分支、循环三种语句已经够用，但是为了方便又有了许多的封装类型
        //包装类
        Integer integer = Integer.valueOf("f", 16);
        Character character = Character.valueOf(c);
        Byte.valueOf("A", 16);
        Short.valueOf("AA", 16);
        Long.valueOf("AAA", 16);
        Boolean aBoolean = Boolean.valueOf("False");
        //浮点型不能进行运算,会丢失精度
        Float aFloat = Float.valueOf("123.21312f");
        Double aDouble = Double.valueOf("123.31423213d");
        //Integer可以进行进制转换
        String s1 = Integer.toHexString(120);
        //String
        String s2 = "234";
        String s3 = new String("");
        try {
            new String(new byte[] {1, 2}, 0, 2, "utf-8");
            new String(new char[] {1, 2}, 0, 2);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        s2.trim();
        s2.startsWith("", 1);
        s2.endsWith("");
        s2.hashCode();
        s2.equals("");
        s2.equalsIgnoreCase("");
        s2.toUpperCase(Locale.ROOT);
        s2.toLowerCase(Locale.ROOT);
        s2.indexOf("", 1);
        s2.lastIndexOf("", 2);
        s2.contains("");
        s2.substring(0,1);
        s2.replaceAll("", "");
        s2.replace('1', '1');
        s2.replaceFirst("", "");
        s2.replace("", "");
        s2.split("", 10);
        s2.concat("");
        s2.matches("");
        s2.charAt(1);
        //BigInteger
        BigInteger bigInteger = BigInteger.valueOf(123l);
        BigInteger bigInteger1 = new BigInteger("1");
        bigInteger.add(BigInteger.valueOf(1));
        bigInteger.subtract(new BigInteger("1"));
        bigInteger.multiply(new BigInteger("1"));
        bigInteger.divide(new BigInteger("1"));
        bigInteger.divideAndRemainder(new BigInteger("1"));
        //BigDecimal
        BigDecimal bigDecimal = BigDecimal.valueOf(123l);
        BigDecimal bigDecimal1 = new BigDecimal("1");
        bigDecimal.add(BigDecimal.valueOf(1l));
        //时间
        Date date = new Date();
        date.getTime();
        date.toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MM dd");
        simpleDateFormat.parse("2002 01 01");
        simpleDateFormat.format(new Date());
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        Instant instant = instance.toInstant();
        instance.add(Calendar.YEAR, 1);
        instance.set(Calendar.YEAR, 2001);

        Duration between = Duration.between(LocalDateTime.now(), LocalDateTime.now());
        Instant instant1 = Instant.ofEpochMilli(1l);
        long l1 = instant1.toEpochMilli();
        LocalDateTime of = LocalDateTime.of(LocalDate.MAX, LocalTime.MIN);
        LocalDateTime localDateTime = of.plusDays(-1);
        LocalDateTime localDateTime1 = of.minusDays(1);
        Date date1 = new Date();
        Instant instant2 = date1.toInstant();
        Date.from(LocalDate.now().minusDays(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuilder.append(1);
        stringBuffer.hashCode();
        stringBuffer.equals("");
    }

    @Test
    public void Test002() {
        //集合操作
        ArrayList<Object> objects = Lists.newArrayList();//默认长度是10，*1.5
        Vector<Object> objects1 = new Vector<>();//10 * 2
        LinkedList<Object> objects2 = new LinkedList<>();//
        objects.add(0, "123");
        objects.add(0, "123345");
        objects.set(1, "789");
        objects.get(0);
        objects.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        objects.isEmpty();
        objects.trimToSize();
        Iterator<Object> iterator = objects.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            iterator.remove();
        }
        objects1.add("");
        HashSet<Object> objects3 = new HashSet<>();//16 * 2
        LinkedHashSet<Object> objects4 = new LinkedHashSet<>();//
        TreeSet<Object> objects5 = new TreeSet<>();//16 * 2

        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        objectObjectHashtable.put("", "");
        objectObjectHashtable.putAll(objectObjectHashtable);
        Set<Map.Entry<Object, Object>> entries = objectObjectHashtable.entrySet();
        Enumeration<Object> keys = objectObjectHashtable.keys();
        Collection<Object> values = objectObjectHashtable.values();
        Set<Object> objects6 = objectObjectHashtable.keySet();
        Properties properties = new Properties();
    }

    @Test
    public void Test003() {
        //stream流
        Stream<Integer> generate = Stream.generate(() -> new Random().nextInt(1)).limit(3);
        Stream<Integer> iterate = Stream.iterate(1, e -> {
            return e * 2;
        }).limit(3);
        IntStream stream = Arrays.stream(new int[]{1, 2, 3});
        Integer[] integers = new Integer[] {
                1, 2
        };
        ArrayList<String> objects = Lists.newArrayList();
        objects.add("1");
        objects.add("null");
        //产生stream流
        //跳过、过滤、截取长度、去重
        //map、flatMap、sort
        //findFirst、findAny、allMatch、anyMatch、noneMatch、count\min\max\foreach、reduce、collect、
        Map<String, String> collect = objects.stream().sorted().map(String::toString).map(String::toString).filter(e -> e != null).filter(e -> e != null).sorted().collect(Collectors.toMap(e -> e.toLowerCase(Locale.ROOT), e -> e, (a, b) -> {
            return a;
        }));
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        String s = Optional.ofNullable(null).map(e -> e.toString()).orElse(null);
        Optional.ofNullable(null).ifPresent(e -> System.out.println("进出口"));
    }

    @Test
    public void Test004() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, IOException, ExecutionException, InterruptedException {
        //IO操作，Socket操作
        URL uri = new URL("");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uri.openConnection();
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();
        OutputStream outputStream = httpURLConnection.getOutputStream();

        //线程操作、线程池操作
        //反射、动态代理invocationhandler methodintercepter
//        Class<PeopleDTO> peopleDTOClass = PeopleDTO.class;
//        Constructor<PeopleDTO> constructor = peopleDTOClass.getConstructor();
//        PeopleDTO peopleDTO = constructor.newInstance();
//        Field field = peopleDTOClass.getDeclaredField("");
//        field.set(peopleDTO, "");
//        Method declaredMethod = peopleDTOClass.getDeclaredMethod("");
//        declaredMethod.setAccessible(true);
//        Object invoke = declaredMethod.invoke(peopleDTO);
        //cas操作 concurenthashmap锁分段 copyonwritearrylist写时复制
        //强软弱虚
        //锁
    }
}
