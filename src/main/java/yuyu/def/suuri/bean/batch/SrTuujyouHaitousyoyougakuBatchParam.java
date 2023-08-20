package yuyu.def.suuri.bean.batch;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.suuri.srcommon.SrCommonConstants;


/**
 * （数理）通常配当所要額情報作成バッチパラメータBEAN データレイアウトのBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@BatchScoped
public class SrTuujyouHaitousyoyougakuBatchParam extends GenSrTuujyouHaitousyoyougakuBatchParam {


    private static final long serialVersionUID = 1L;


    private static final String RGHIX000 = "RGHIX000";


    private static final String RGHIX001 = "RGHIX001";


    private static final String RGHIX002 = "RGHIX002";


    private static final String RGHIX003 = "RGHIX003";


    private static final String RGHIX004 = "RGHIX004";


    private static final String RGHIX005 = "RGHIX005";


    private static final String RGHIX006 = "RGHIX006";


    private static final String RGHIX008 = "RGHIX008";


    private static final String RGHIX009 = "RGHIX009";


    private static final String RGHIX010 = "RGHIX010";


    private static final String RGHIX011 = "RGHIX011";


    public SrTuujyouHaitousyoyougakuBatchParam() {



        super.setIbSyorikensuu(0);
    }


    public void setParam() {


        String ibHaitousyoyougakukeisancd = "";




        if (RGHIX000.equals(super.getIbKakutyoujobcd())
            || RGHIX003.equals(super.getIbKakutyoujobcd())
            || RGHIX008.equals(super.getIbKakutyoujobcd())) {


            ibHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO;
        }



        else if (RGHIX001.equals(super.getIbKakutyoujobcd())
            || RGHIX004.equals(super.getIbKakutyoujobcd())
            || RGHIX009.equals(super.getIbKakutyoujobcd())) {


            ibHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ONE;

        }



        else if (RGHIX002.equals(super.getIbKakutyoujobcd())
            || RGHIX005.equals(super.getIbKakutyoujobcd())
            || RGHIX010.equals(super.getIbKakutyoujobcd())) {


            ibHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_TWO;
        }


        else if (RGHIX006.equals(super.getIbKakutyoujobcd())
            || RGHIX011.equals(super.getIbKakutyoujobcd())) {


            ibHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO;
        }




        else {


            ibHaitousyoyougakukeisancd = SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART;
        }


        BizDateYM ibKeijyouym =  super.getIbKijyunymd().getBizDateYM();


        BizDateY ibDratenendo = null;


        BizDateY ibKeisanDnendo = null;


        if (SrCommonConstants.MONTH_MARCH ==  super.getIbKijyunymd().getMonth()) {


            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY();


                ibKeisanDnendo = ibKeijyouym.getBizDateY();

            }

            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ONE.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY();


                ibKeisanDnendo = ibKeijyouym.getBizDateY().addYears(+1);
            }

            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_TWO.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY();


                ibKeisanDnendo = ibKeijyouym.getBizDateY().addYears(+2);
            }

            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_MINUS_ZERO.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY().addYears(-1);


                ibKeisanDnendo = ibKeijyouym.getBizDateY();
            }

        }

        else if (SrCommonConstants.MONTH_JANUARY ==  super.getIbKijyunymd().getMonth()) {

            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY().addYears(-1);


                ibKeisanDnendo = ibKeijyouym.getBizDateY();

            }

            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ONE.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY().addYears(-1);


                ibKeisanDnendo = ibKeijyouym.getBizDateY().addYears(+1);
            }

            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_TWO.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY().addYears(-1);


                ibKeisanDnendo = ibKeijyouym.getBizDateY().addYears(+2);
            }
        }

        else {

            if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ZERO.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY();


                ibKeisanDnendo = ibKeijyouym.getBizDateY().addYears(+1);

            }

            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_ONE.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY();


                ibKeisanDnendo = ibKeijyouym.getBizDateY().addYears(+2);
            }

            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_TWO.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY();


                ibKeisanDnendo = ibKeijyouym.getBizDateY().addYears(+3);
            }

            else if (SrCommonConstants.HAITOUSYOYOUGAKUKEISANCD_N_PLUS_QUART.equals(ibHaitousyoyougakukeisancd)) {

                ibDratenendo = ibKeijyouym.getBizDateY();


                ibKeisanDnendo = ibKeijyouym.getBizDateY();
            }
        }



        super.setIbKeijyouym(ibKeijyouym);


        super.setIbHaitousyoyougakukeisancd(ibHaitousyoyougakukeisancd);


        super.setIbDratenendo(ibDratenendo);


        super.setIbKeisanDnendo(ibKeisanDnendo);


        super.setIbSyorikensuu(0);

    }
}
