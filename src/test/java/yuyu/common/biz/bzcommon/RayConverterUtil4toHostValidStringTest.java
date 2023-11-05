package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWAKTestRunner.class)
public class RayConverterUtil4toHostValidStringTest {

    @Test
    public void testNull(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        RayConvertUtil.toValidString(bean);
        assertEquals(null, bean.getToHostInvalidItem1());

        bean = null;
        RayConvertUtil.toValidString(bean);
        assertEquals(null, bean);
    }

    @Test
    public void testBlank(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("");
        RayConvertUtil.toValidString(bean);
        assertEquals("", bean.getToHostInvalidItem1());
    }

    @Test
    public void testMark(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("、。／");
        RayConvertUtil.toValidString(bean);
        assertEquals("、。／", bean.getToHostInvalidItem1());
    }

    @Test
    public void test1Suijyun(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("あア亜");
        RayConvertUtil.toValidString(bean);
        assertEquals("あア亜", bean.getToHostInvalidItem1());
    }

    @Test
    public void test2Suijyun(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("弌冲勹");
        RayConvertUtil.toValidString(bean);
        assertEquals("弌冲勹", bean.getToHostInvalidItem1());
    }

    @Test
    public void test3Suijyun(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("丨侊冝");
        RayConvertUtil.toValidString(bean);
        assertEquals("丨侊冝", bean.getToHostInvalidItem1());
    }

    @Test
    public void test4Suijyun(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("伀侒侚");
        RayConvertUtil.toValidString(bean);
        assertEquals("伀侒侚", bean.getToHostInvalidItem1());
    }

    @Test
    public void testSingleByte(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("ｱA1");
        RayConvertUtil.toValidString(bean);
        assertEquals("ｱA1", bean.getToHostInvalidItem1());
    }

    @Test
    public void testSingleByteHostInvalidChar(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("aｧ!");
        RayConvertUtil.toValidString(bean);
        assertEquals("Aｱ ", bean.getToHostInvalidItem1());
    }

    @Test
    public void testSingleByteHostInvalidCharZenpou(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("aｧ!123");
        RayConvertUtil.toValidString(bean);
        assertEquals("Aｱ 123", bean.getToHostInvalidItem1());
    }

    @Test
    public void testSingleByteHostInvalidCharBubun(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("123aｧ!123");
        RayConvertUtil.toValidString(bean);
        assertEquals("123Aｱ 123", bean.getToHostInvalidItem1());
    }

    @Test
    public void testSingleByteHostInvalidCharKouhou(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("123aｧ!");
        RayConvertUtil.toValidString(bean);
        assertEquals("123Aｱ ", bean.getToHostInvalidItem1());
    }

    @Test
    public void testSingleByteHostInvalidCharBean(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("aｧ!");
        bean.setToHostInvalidItem2("aｧ!");
        bean.setItem("aｧ!");
        RayConvertUtil.toValidString(bean);
        assertEquals("Aｱ ", bean.getToHostInvalidItem1());
        assertEquals("Aｱ ", bean.getToHostInvalidItem2());
        assertEquals("aｧ!", bean.getItem());
    }

    @Test
    public void testMultiByteHostInvalidChar(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("ａァ！");
        RayConvertUtil.toValidString(bean);
        assertEquals("Ａア　", bean.getToHostInvalidItem1());
    }

    @Test
    public void testMultiByteHostInvalidCharZenpou(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("ａァ！１２３");
        RayConvertUtil.toValidString(bean);
        assertEquals("Ａア　１２３", bean.getToHostInvalidItem1());
    }

    @Test
    public void testMultiByteHostInvalidCharBubun(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("１２３ａァ！１２３");
        RayConvertUtil.toValidString(bean);
        assertEquals("１２３Ａア　１２３", bean.getToHostInvalidItem1());
    }

    @Test
    public void testMultiByteHostInvalidCharKouhou(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("１２３ａァ！");
        RayConvertUtil.toValidString(bean);
        assertEquals("１２３Ａア　", bean.getToHostInvalidItem1());
    }

    @Test
    public void testMultiByteHostInvalidCharBean(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("ａァ！");
        bean.setToHostInvalidItem2("ａァ！");
        bean.setItem("ａァ！");
        RayConvertUtil.toValidString(bean);
        assertEquals("Ａア　", bean.getToHostInvalidItem1());
        assertEquals("Ａア　", bean.getToHostInvalidItem2());
        assertEquals("ａァ！", bean.getItem());
    }

    @Test
    public void testHostInvalidCharMoura(){
        HostInvalidTestBean bean = new HostInvalidTestBean();
        bean.setToHostInvalidItem1("abcdefghijklmnopqrstuvwxyzｦｧｨｩｪｫｬｭｮｯ![]^ｰ`{|}~ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚヲァィゥェォャュョッ！［］＾ー｀｛｜｝￣");
        RayConvertUtil.toValidString(bean);
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZｵｱｲｳｴｵﾔﾕﾖﾂ    -@ \\  ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺオアイウエオヤユヨツ　　　　－＠　￥　　", bean.getToHostInvalidItem1());
    }

}