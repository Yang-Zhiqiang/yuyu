package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.suuri.srcommon.SrCommonConstants;


/**
 * （数理）利差のみ通常配当所要額情報作成バッチパラメータBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@BatchScoped
public class SrRisanomiTuujyouHaitousyoyougakuBatchParam extends GenSrRisanomiTuujyouHaitousyoyougakuBatchParam {


    private static final long serialVersionUID = 1L;


    private static final String RGHJX000 = "RGHJX000";


    private static final String RGHJX001 = "RGHJX001";


    private static final String RGHJX002 = "RGHJX002";


    private static final String RGHJX003 = "RGHJX003";


    private static final String RGHJX004 = "RGHJX004";


    private static final String RGHJX005 = "RGHJX005";


    private static final String RGHJX006 = "RGHJX006";


    public SrRisanomiTuujyouHaitousyoyougakuBatchParam() {
    }


    public void setParam(String ibKakutyoujobcd, BizDate ibKijyunymd) {



        BizDate wkibKijyunymd = ibKijyunymd;


        String ibHaitousyoyougakukeisancd = "";




        if (RGHJX000.equals(ibKakutyoujobcd)
            || RGHJX001.equals(ibKakutyoujobcd)
            || RGHJX004.equals(ibKakutyoujobcd)) {


            ibHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO;
        }


        else if (RGHJX002.equals(ibKakutyoujobcd)
            || RGHJX005.equals(ibKakutyoujobcd)) {


            ibHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART;
        }


        else {


            ibHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO;
        }


        BizDateYM ibKeijyouym = wkibKijyunymd.getBizDateYM();


        BizDateY ibDratenendo = null;


        BizDateY ibKeisanDnendo = null;


        if (SrCommonConstants.MONTH_MARCH == wkibKijyunymd.getMonth()) {


            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY();


                ibKeisanDnendo = ibKeijyouym.getBizDateY();

            }

            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY().addYears(-1);


                ibKeisanDnendo = ibKeijyouym.getBizDateY();
            }

        }

        else if (SrCommonConstants.MONTH_JANUARY == wkibKijyunymd.getMonth()) {

            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY().addYears(-1);


                ibKeisanDnendo = ibKeijyouym.getBizDateY();

            }
        }

        else {

            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY();


                ibKeisanDnendo = ibKeijyouym.getBizDateY().addYears(+1);

            }

            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY();


                ibKeisanDnendo = ibKeijyouym.getBizDateY();
            }
        }



        super.setIbKijyunymd(wkibKijyunymd);


        super.setIbKeijyouym(ibKeijyouym);


        super.setIbHaitousyoyougakukeisancd(ibHaitousyoyougakukeisancd);


        super.setIbDratenendo(ibDratenendo);


        super.setIbKeisanDnendo(ibKeisanDnendo);


        super.setIbSyorikensuu(0);

    }

}
