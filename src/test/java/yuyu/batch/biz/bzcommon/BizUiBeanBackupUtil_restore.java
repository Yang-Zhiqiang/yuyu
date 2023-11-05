package yuyu.batch.biz.bzcommon;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.biz.bztyouhyou.bztyouhyouikkatu.BzTyouhyouIkkatuUiBean;
import yuyu.app.biz.bztyouhyou.bztyouhyouikkatu.SearchKeyListDataSourceBean;
import yuyu.common.biz.bzcommon.BizUiBeanBackupUtil;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_TyousaJyoukyouKbn;
import yuyu.def.siharai.result.bean.DoujiSeikyuuInfosBySknoSyonoNeBean;

@RunWith(SWAKTestRunner.class)
public class BizUiBeanBackupUtil_restore {

    private static DoujiSeikyuuInfosBySknoSyonoNeBean src1 = new DoujiSeikyuuInfosBySknoSyonoNeBean("SK0001","SN0001",C_SeikyuuSyubetu.KOUSG,C_SyoriJyoutaiKbn.KANRYOU,C_HubiJyoukyouKbn.HUBI,C_TyousaJyoukyouKbn.HUBI,BizDate.valueOf("20161021"));
    private static DoujiSeikyuuInfosBySknoSyonoNeBean dst1 = new DoujiSeikyuuInfosBySknoSyonoNeBean(null,null,null,null,null,null,null);

    private static BzTyouhyouIkkatuUiBean src2 = new BzTyouhyouIkkatuUiBean();
    private static BzTyouhyouIkkatuUiBean dst2 = new BzTyouhyouIkkatuUiBean();


    @BeforeClass
    public static void prepareData(){

        src2.setMisyuturyokukensuu(11);
        src2.setModorubtnbykensaku("１１");
        src2.setRoleCds(new String[]{"1","11","111"});
        src2.setSubSystemId("11");

        List<SearchKeyListDataSourceBean> list = new ArrayList<SearchKeyListDataSourceBean>();
        SearchKeyListDataSourceBean bean3 = new SearchKeyListDataSourceBean();
        bean3.setKnskkmknm1("カナ３");
        bean3.setReportKey("key3");
        list.add(bean3);
        SearchKeyListDataSourceBean bean2 = new SearchKeyListDataSourceBean();
        bean2.setKnskkmknm1("カナ２");
        bean2.setReportKey("key2");
        list.add(bean2);
        SearchKeyListDataSourceBean bean1 = new SearchKeyListDataSourceBean();
        bean1.setKnskkmknm1("カナ１");
        bean1.setReportKey("key1");
        list.add(bean1);
        src2.getSearchKeyListDataSource().setDatas(list);

    }


    @Test
    public void test1(){
        System.out.println("test1 start---------------------------------------------------");
        BizUiBeanBackupUtil.restore(dst1,src1);
        assertEquals(src1.getSkno(),dst1.getSkno());
        assertEquals(src1.getSyono(),dst1.getSyono());
        assertEquals(src1.getHubijyoukyoukbn(),dst1.getHubijyoukyoukbn());
        assertEquals(src1.getSaisinSyoriYmd(),dst1.getSaisinSyoriYmd());
        assertEquals(src1.getSeikyuusyubetu(),dst1.getSeikyuusyubetu());
        assertEquals(src1.getSyorijyoutaikbn(),dst1.getSyorijyoutaikbn());
        assertEquals(src1.getTyousajyoukyoukbn(),dst1.getTyousajyoukyoukbn());

        dst1.setSkno("SK0002");
        dst1.setSyono("SN0002");
        assertEquals(src1.getSkno(),"SK0001");
        assertEquals(src1.getSyono(),"SN0001");

        src1.setHubijyoukyoukbn(C_HubiJyoukyouKbn.KAISYOU);
        src1.setSaisinSyoriYmd(BizDate.valueOf("20161022"));
        assertEquals(dst1.getHubijyoukyoukbn(),C_HubiJyoukyouKbn.HUBI);
        assertEquals(dst1.getSaisinSyoriYmd(),BizDate.valueOf("20161021"));

        System.out.println("test1 end-----------------------------------------------------");
    }

    @Test
    public void test2(){
        System.out.println("test2 start---------------------------------------------------");
        BizUiBeanBackupUtil.restore(dst2,src2);

        assertEquals(src2.getMisyuturyokukensuu(),dst2.getMisyuturyokukensuu());
        assertEquals(src2.getRoleCds().length,dst2.getRoleCds().length);
        assertEquals(src2.getModorubtnbykensaku(),dst2.getModorubtnbykensaku());
        assertEquals(src2.getSubSystemId(),dst2.getSubSystemId());
        assertEquals(src2.getSearchKeyListDataSource().getDatas().size(),dst2.getSearchKeyListDataSource().getDatas().size());

        dst2.setMisyuturyokukensuu(22);
        assertEquals(src2.getMisyuturyokukensuu(),Integer.valueOf(11));
        dst2.getSearchKeyListDataSource().getDatas().get(0).setKnskkmknm1("カナ");
        assertEquals(src2.getSearchKeyListDataSource().getDatas().get(0).getKnskkmknm1(),"カナ");
        SearchKeyListDataSourceBean bean1 = new SearchKeyListDataSourceBean();
        bean1.setKnskkmknm1("カナ４");
        bean1.setReportKey("key4");
        dst2.getSearchKeyListDataSource().getDatas().add(bean1);
        assertEquals(src2.getSearchKeyListDataSource().getDatas().size(),4);

        src2.getSearchKeyListDataSource().getDatas().get(1).setKnskkmknm1("カナ");
        assertEquals(dst2.getSearchKeyListDataSource().getDatas().get(1).getKnskkmknm1(),"カナ");
        src2.getSearchKeyListDataSource().getDatas().remove(3);
        assertEquals(dst2.getSearchKeyListDataSource().getDatas().size(),3);


        System.out.println("test2 end-----------------------------------------------------");
    }



    @Test
    public void test3(){
        System.out.println("test3 start---------------------------------------------------");
        DoujiSeikyuuInfosBySknoSyonoNeBean backup1 = new DoujiSeikyuuInfosBySknoSyonoNeBean(null,null,null,null,null,null,null);
        BizUiBeanBackupUtil.backup(src1,backup1);
        DoujiSeikyuuInfosBySknoSyonoNeBean restore1 = new DoujiSeikyuuInfosBySknoSyonoNeBean(null,null,null,null,null,null,null);
        BizUiBeanBackupUtil.restore(restore1,backup1);
        assertEquals(src1.getSkno(),restore1.getSkno());
        assertEquals(src1.getSyono(),restore1.getSyono());
        assertEquals(src1.getHubijyoukyoukbn(),restore1.getHubijyoukyoukbn());
        assertEquals(src1.getSaisinSyoriYmd(),restore1.getSaisinSyoriYmd());
        assertEquals(src1.getSeikyuusyubetu(),restore1.getSeikyuusyubetu());
        assertEquals(src1.getSyorijyoutaikbn(),restore1.getSyorijyoutaikbn());
        assertEquals(src1.getTyousajyoukyoukbn(),restore1.getTyousajyoukyoukbn());

        BzTyouhyouIkkatuUiBean backup2 = new BzTyouhyouIkkatuUiBean();
        BizUiBeanBackupUtil.backup(src2,backup2);
        BzTyouhyouIkkatuUiBean restore2 = new BzTyouhyouIkkatuUiBean();
        BizUiBeanBackupUtil.restore(restore2,backup2);

        assertEquals(src2.getMisyuturyokukensuu(),restore2.getMisyuturyokukensuu());
        assertEquals(src2.getRoleCds().length,restore2.getRoleCds().length);
        assertEquals(src2.getModorubtnbykensaku(),restore2.getModorubtnbykensaku());
        assertEquals(src2.getSubSystemId(),restore2.getSubSystemId());
        assertEquals(src2.getSearchKeyListDataSource().getDatas().size(),restore2.getSearchKeyListDataSource().getDatas().size());

        System.out.println("test3 end-----------------------------------------------------");
    }

}


