
# 一、标题

# 一级标题
## 二级标题
### 三级标题
#### 四级标题
##### 五级标题
###### 六级标题

# 二、字体

*斜体*
<br>
**加粗**
<br>
***倾斜加上加粗***
<br>
~~删除线~~
<br>

# 三、引用
> 这是一个一级引用
>> 这是一个二级引用
>>> 这是一个三级引用，以此类推

# 四、分割线

~~~
    三个三个以上的 - 或者 *
~~~
----------
**********

# 五、图片

~~~
    ![图片alt](图片地址 ''图片title'')
    
    图片alt就是显示在图片下面的文字，相当于对图片内容的解释。
    图片title是图片的标题，当鼠标移到图片上时显示的内容。title可加可不加
~~~

![blockchain](https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=702257389,1274025419&fm=27&gp=0.jpg "区块链")

# 六、超链接

~~~
    [超链接名](超链接地址 "超链接title")
    title可加可不加
~~~

[简书](http://jianshu.com)
<br>
[百度](http://baidu.com)

# 七、列表
~~~
- 列表内容
+ 列表内容
* 列表内容

注意：- + * 跟内容之间都要有一个空格
~~~

- 列表内容
+ 列表内容
* 列表内容

~~~
    1.列表内容
    2.列表内容
    3.列表内容
    
    注意：序号跟内容之间要有空格
~~~
1. 有序列表
2. 有序列表

~~~
列表嵌套
上一级和下一级之间敲三个空格即可
~~~

- 无序列表
   + 无序列表
      1. 有序列表
         1. 有序列表
            1. 有序列表
            * 无序列表
# 八、表格
~~~
表头|表头|表头
---|:--:|---:
内容|内容|内容
内容|内容|内容

第二行分割表头和内容。
- 有一个就行，为了对齐，多加了几个
文字默认居左
-两边加：表示文字居中
-右边加：表示文字居右
注：原生的语法两边都要用 | 包起来。此处省略
~~~

姓名 | 技能 | 排行
-- |: --: | --:
刘备 | 哭 | 大哥
关羽 | 打 | 二哥
张飞 | 骂 | 三弟

- 极简方法

name | 价格 |  数量  
-|-|-
香蕉 | $1 | 5 |
苹果 | $1 | 6 |
草莓 | $1 | 7 |

- 简单方法

name | 111 | 222 | 333 | 444
-- | :-: | :-: | :-: | -:
aaa | bbb | ccc | ddd | eee| 
fff | ggg| hhh | iii | 000|

- 原生方法

name | 111 | 222 | 333 | 444
:-: | :-: | :-: | :-: | :-:
aaa | bbb | ccc | ddd | eee| 
fff | ggg| hhh | iii | 000|

# 九、代码

~~~
单行代码
  
``
~~~
`select * from tb_user`

~~~
多行代码

```
```
~~~

```java
import org.apache.log4j.*;
import org.aspectj.*;
import static org.junit.Assert.*;
```

# 十、流程图

```flow
st=>start: 开始
op=>operation: My Operation
cond=>condition: Yes or No?
e=>end
st->op->cond
cond(yes)->e
cond(no)->op
```

~~~
&nbsp;
它叫不换行空格，全称No-Break Space，它是最常见和我们使用最多的空格，大多数的人可能只接触了 ，它是按下space键产生的空格。在HTML中，如果你用空格键产生此空格，空格是不会累加的（只算1个）。要使用html实体表示才可累加，该空格占据宽度受字体影响明显而强烈。

&ensp;
它叫“半角空格”，全称是En Space，en是字体排印学的计量单位，为em宽度的一半。根据定义，它等同于字体度的一半（如16px字体中就是8px）。名义上是小写字母n的宽度。此空格传承空格家族一贯的特性：透明的，此空格有个相当稳健的特性，就是其占据的宽度正好是1/2个中文宽度，而且基本上不受字体影响。

&emsp;
它叫“全角空格”，全称是Em Space，em是字体排印学的计量单位，相当于当前指定的点数。例如，1 em在16px的字体中就是16px。此空格也传承空格家族一贯的特性：透明的，此空格也有个相当稳健的特性，就是其占据的宽度正好是1个中文宽度，而且基本上不受字体影响。

&thinsp;
它叫窄空格，全称是Thin Space。我们不妨称之为“瘦弱空格”，就是该空格长得比较瘦弱，身体单薄，占据的宽度比较小。它是em之六分之一宽。

&zwnj;
它叫零宽不连字，全称是Zero Width Non Joiner，简称“ZWNJ”，是一个不打印字符，放在电子文本的两个字符之间，抑制本来会发生的连字，而是以这两个字符原本的字形来绘制。Unicode中的零宽不连字字符映射为“”（zero widthnon-joiner，U+200C），HTML字符值引用为： ‌

&zwj;
它叫零宽连字，全称是Zero Width Joiner，简称“ZWJ”，是一个不打印字符，放在某些需要复杂排版语言（如阿拉伯语、印地语）的两个字符之间，使得这两个本不会发生连字的字符产生了连字效果。零宽连字符的Unicode码位是U+200D(HTML: ‍ ‍）

~~~
