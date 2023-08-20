package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.common.suuri.srcommon.SrCommonConstants;

/**
 * （数理）異動明細情報作成バッチパラメータBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@BatchScoped
public class SrIdouMeisaiBatchParam extends GenSrIdouMeisaiBatchParam {


    private static final long serialVersionUID = 1L;


    public SrIdouMeisaiBatchParam() {


        super.setIbSyorikensuu(0);
    }


    public void setParam() {



        SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);


        BizDate zengetuDenSimeYMD = setDenSimebi.exec(super.getIbKijyunymd());


        super.setIbZenkaidensimeymd(zengetuDenSimeYMD);



        BizDate nendoksnbi = null;


        if (super.getIbKijyunymd().getMonth() >= SrCommonConstants.MONTH_MARCH) {


            nendoksnbi = BizDate.valueOf(String.valueOf(super.getIbKijyunymd().getYear()) + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }

        else {


            nendoksnbi = BizDate.valueOf(String.valueOf((super.getIbKijyunymd().getYear() - 1)) +
                SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }


        super.setIbJigyounendoKsnbiymd(nendoksnbi);
    }
}
