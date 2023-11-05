package yuyu.common.biz.bzfiledl;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.siharai.file.csv.SiMktKnrRendouLayoutFile;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

import com.google.common.collect.Lists;

/**
 * ファイルアップロードユーティリティー メソッド{@link BzFileUploadUtil#exec(C_FileSyuruiCdKbn, List<T>, boolean)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFileUploadUtilTest_filepath extends AbstractTest {

    @Inject
    private BzFileUploadUtil bzFileUploadUtil;

    @Inject
    private BzBatchParam bzBatchParam;

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        changeSystemDate(BizDate.valueOf(20160106));

        bzBatchParam.setSyoriYmd(BizDate.valueOf(20160701));
        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.SI_SBKARIUKEINFO;
        List<SiMktKnrRendouLayoutFile> beanLst = Lists.newArrayList();
        SiMktKnrRendouLayoutFile skTskmlistLayoutFile = new SiMktKnrRendouLayoutFile();
        skTskmlistLayoutFile.setIfcKihontikucd("1");
        beanLst.add(skTskmlistLayoutFile);

        boolean fileDateFlg = true;

        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(fileSyuruiCdKbn, beanLst, fileDateFlg);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

    }

}