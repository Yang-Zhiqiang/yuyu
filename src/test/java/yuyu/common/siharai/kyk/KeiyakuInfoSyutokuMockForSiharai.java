package yuyu.common.siharai.kyk;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.siharai.chksk.CheckSbSkNaiyouTest_exec;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiUkt;

/**
 * {@link KeiyakuInfoSyutoku}のモッククラスです。<br />
 */
public class KeiyakuInfoSyutokuMockForSiharai extends KeiyakuInfoSyutoku {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static String mode = null;

    private List<JT_SiKykKihon> siKykKihonLst;

    @Override
    public void getInfos(KeiyakuPrm pKp) {

        if (caller == CheckSbSkNaiyouTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon = null;

                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihonList.add(siKykKihon);

                this.siKykKihonLst = siKykKihonList;
                return ;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000023");
                JT_SiKykSyouhn siKykSyouhn = siKykKihon.createSiKykSyouhn();
                siKykSyouhn.setSyono("17809000023");
                siKykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn.setSyouhncd("W101");
                siKykSyouhn.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn.setSyouhnsdno(10);
                siKykSyouhn.setKyksyouhnrenno(1);
                siKykSyouhn.setSyouhnnm("商品名");
                siKykSyouhn.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);

                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN3.equals(SYORIPTN)
                && "17809000045".equals(pKp.getSyono())) {
                super.getInfos(pKp);
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setNstkhkumu(C_UmuKbn.NONE);
                siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
                siKykKihon.setSyono("17809000045");
                siKykKihon.setTsinyno("");
                siKykKihon.setOyadrtencd("");

                JT_SiKykSyouhn siKykSyouhn = siKykKihon.createSiKykSyouhn();
                siKykSyouhn.setSyono("17809000045");
                siKykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn.setSyouhncd("W103");
                siKykSyouhn.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn.setSyouhnsdno(10);
                siKykSyouhn.setKyksyouhnrenno(1);
                siKykSyouhn.setSyouhnnm("商品名");
                siKykSyouhn.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);

                JT_SiUkt siUkt1 = SWAKInjector.getInstance(JT_SiUkt.class);
                siUkt1.setSyono("17809000045");
                siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
                siUkt1.setUktsyurenno(1);

                List<JT_SiUkt> siUktsList = new ArrayList<>();
                siUktsList.add(siUkt1);
                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihon.setSiUkts(siUktsList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;

                return;
            }
            if (TESTPATTERN3.equals(SYORIPTN)
                && "17809000067".equals(pKp.getSyono())) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000067");
                siKykKihon.setTsinyno("1234567");
                siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.TTDKTYUUOUTAITYUUI);
                siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.BLNK);
                siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.BLNK);
                siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
                siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
                siKykKihon.setKyknmkn("カナ");

                JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn1.setSyono("17809000067");
                siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn1.setSyouhncd("W105");
                siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn1.setSyouhnsdno(10);
                siKykSyouhn1.setKyksyouhnrenno(1);
                siKykSyouhn1.setSyouhnnm("商品名");
                siKykSyouhn1.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn1.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
                siKykSyouhn1.setHknkknmanryouymd(BizDate.valueOf("20151117"));

                JT_SiUkt siUkt1 = SWAKInjector.getInstance(JT_SiUkt.class);
                siUkt1.setSyono("17809000067");
                siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
                siUkt1.setUktsyurenno(1);
                siUkt1.setUktnmkn("かかＡ");
                siUkt1.setUktkbn(C_UktKbn.KYK);
                siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);

                List<JT_SiUkt> siUktsList = new ArrayList<>();
                siUktsList.add(siUkt1);
                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn1);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihon.setSiUkts(siUktsList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return ;
            }
            if (TESTPATTERN3.equals(SYORIPTN)
                && "17809000126".equals(pKp.getSyono())) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000126");
                siKykKihon.setStknsetkbn(C_StknsetKbn.ARI);
                siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
                siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
                siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
                siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
                siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
                siKykKihon.setTsinyno("1234567");

                JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn1.setSyono("17809000126");
                siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn1.setSyouhncd("W009");
                siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn1.setSyouhnsdno(10);
                siKykSyouhn1.setKyksyouhnrenno(1);
                siKykSyouhn1.setSyouhnnm("商品名");
                siKykSyouhn1.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn1.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);

                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn1);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN3.equals(SYORIPTN)
                && "17809000137".equals(pKp.getSyono())) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000137");
                siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
                siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI);
                siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.SEIZENKYUUHUHIGAITOU);
                siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
                siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HOZENSONOTA);
                siKykKihon.setTsinyno("1234567");

                JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn1.setSyono("17809000137");
                siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn1.setSyouhncd("W010");
                siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn1.setSyouhnsdno(10);
                siKykSyouhn1.setKyksyouhnrenno(1);
                siKykSyouhn1.setSyouhnnm("商品名");
                siKykSyouhn1.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn1.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);

                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn1);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN3.equals(SYORIPTN)
                && "17809000148".equals(pKp.getSyono())) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000148");
                siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE);
                siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI);
                siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
                siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.DAIRININTTDKHUKA);
                siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.KYKSYAISINOURYOKUNASI);
                siKykKihon.setTsinyno("1234567");

                JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn1.setSyono("17809000148");
                siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn1.setSyouhncd("W011");
                siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn1.setSyouhnsdno(10);
                siKykSyouhn1.setKyksyouhnrenno(1);
                siKykSyouhn1.setSyouhnnm("商品名");
                siKykSyouhn1.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn1.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);

                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn1);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN3.equals(SYORIPTN)
                && "17809000159".equals(pKp.getSyono())) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000159");
                siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.KYKSYASOUSASYOUKAI);
                siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
                siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
                siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
                siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
                siKykKihon.setTsinyno("1234567");

                JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn1.setSyono("17809000159");
                siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn1.setSyouhncd("W012");
                siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn1.setSyouhnsdno(10);
                siKykSyouhn1.setKyksyouhnrenno(1);
                siKykSyouhn1.setSyouhnnm("商品名");
                siKykSyouhn1.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn1.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);

                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn1);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN3.equals(SYORIPTN)
                && "17809000160".equals(pKp.getSyono())) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000160");
                siKykKihon.setTsinyno("1234567");

                JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn1.setSyono("17809000160");
                siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn1.setSyouhncd("W013");
                siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn1.setSyouhnsdno(10);
                siKykSyouhn1.setKyksyouhnrenno(1);
                siKykSyouhn1.setSyouhnnm("商品名");
                siKykSyouhn1.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn1.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);

                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn1);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000056");
                siKykKihon.setTsinyno("1234567");
                siKykKihon.setHksknnkaisiymd(BizDate.valueOf("20150506"));

                JT_SiKykSyouhn siKykSyouhn = siKykKihon.createSiKykSyouhn();
                siKykSyouhn.setSyono("17809000056");
                siKykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn.setSyouhncd("W104");
                siKykSyouhn.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn.setSyouhnsdno(10);
                siKykSyouhn.setKyksyouhnrenno(1);
                siKykSyouhn.setSyouhnnm("商品名");
                siKykSyouhn.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
                siKykSyouhn.setSknnkaisiymd(BizDate.valueOf("20150503"));

                JT_SiUkt siUkt1 = SWAKInjector.getInstance(JT_SiUkt.class);
                siUkt1.setSyono("17809000056");
                siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
                siUkt1.setUktsyurenno(1);
                siUkt1.setUktnmkn("かかＡ");

                List<JT_SiUkt> siUktsList = new ArrayList<>();
                siUktsList.add(siUkt1);
                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihon.setSiUkts(siUktsList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000089");
                siKykKihon.setTsinyno("1234567");
                siKykKihon.setHksknnkaisiymd(null);

                JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn1.setSyono("17809000089");
                siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn1.setSyouhncd("W114");
                siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn1.setSyouhnsdno(10);
                siKykSyouhn1.setKyksyouhnrenno(1);
                siKykSyouhn1.setSyouhnnm("商品名");
                siKykSyouhn1.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn1.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.USD);
                siKykSyouhn1.setSknnkaisiymd(BizDate.valueOf("20150506"));
                JT_SiKykSyouhn siKykSyouhn2 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn2.setSyono("17809000089");
                siKykSyouhn2.setSyutkkbn(C_SyutkKbn.TK);
                siKykSyouhn2.setSyouhncd("W115");
                siKykSyouhn2.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn2.setSyouhnsdno(10);
                siKykSyouhn2.setKyksyouhnrenno(2);
                siKykSyouhn2.setSyouhnnm("商品名");
                siKykSyouhn2.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn2.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn2.setKyktuukasyu(C_Tuukasyu.JPY);
                siKykSyouhn2.setSknnkaisiymd(BizDate.valueOf("20150506"));

                JT_SiUkt siUkt1 = SWAKInjector.getInstance(JT_SiUkt.class);
                siUkt1.setSyono("17809000089");
                siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
                siUkt1.setUktsyurenno(1);
                siUkt1.setUktnmkn("かかＡ");

                List<JT_SiUkt> siUktsList = new ArrayList<>();
                siUktsList.add(siUkt1);
                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn1);
                SiKykSyouhnList.add(siKykSyouhn2);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihon.setSiUkts(siUktsList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000078");
                siKykKihon.setTsinyno("1234567");
                siKykKihon.setHksknnkaisiymd(null);

                JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn1.setSyono("17809000078");
                siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn1.setSyouhncd("W106");
                siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn1.setSyouhnsdno(10);
                siKykSyouhn1.setKyksyouhnrenno(1);
                siKykSyouhn1.setSyouhnnm("商品名");
                siKykSyouhn1.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn1.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
                siKykSyouhn1.setSknnkaisiymd(BizDate.valueOf("20130505"));

                JT_SiUkt siUkt1 = SWAKInjector.getInstance(JT_SiUkt.class);
                siUkt1.setSyono("17809000078");
                siUkt1.setHkuktsyu(C_Hkuktsyu.KYFKUKT);
                siUkt1.setUktsyurenno(1);
                siUkt1.setUktnmkn("かかＡ");

                List<JT_SiUkt> siUktsList = new ArrayList<>();
                siUktsList.add(siUkt1);
                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn1);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihon.setSiUkts(siUktsList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000090");
                siKykKihon.setHksknnkaisiymd(null);
                siKykKihon.setTsinyno("1234567");

                JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn1.setSyono("17809000090");
                siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn1.setSyouhncd("W116");
                siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn1.setSyouhnsdno(10);
                siKykSyouhn1.setKyksyouhnrenno(1);
                siKykSyouhn1.setSyouhnnm("商品名");
                siKykSyouhn1.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn1.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
                siKykSyouhn1.setSknnkaisiymd(BizDate.valueOf("20130505"));
                JT_SiKykSyouhn siKykSyouhn2 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn2.setSyono("17809000090");
                siKykSyouhn2.setSyutkkbn(C_SyutkKbn.TK);
                siKykSyouhn2.setSyouhncd("W117");
                siKykSyouhn2.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn2.setSyouhnsdno(10);
                siKykSyouhn2.setKyksyouhnrenno(1);
                siKykSyouhn2.setSyouhnnm("商品名");
                siKykSyouhn2.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn2.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn2.setKyktuukasyu(C_Tuukasyu.JPY);
                siKykSyouhn2.setSknnkaisiymd(BizDate.valueOf("20130505"));

                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn1);
                SiKykSyouhnList.add(siKykSyouhn2);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN8.equals(SYORIPTN)) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000104");
                siKykKihon.setTsinyno("1234567");

                JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn1.setSyono("17809000104");
                siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn1.setSyouhncd("W107");
                siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn1.setSyouhnsdno(10);
                siKykSyouhn1.setKyksyouhnrenno(1);
                siKykSyouhn1.setSyouhnnm("商品名");
                siKykSyouhn1.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn1.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
                siKykSyouhn1.setSknnkaisiymd(BizDate.valueOf("20150506"));

                JT_SiUkt siUkt1 = SWAKInjector.getInstance(JT_SiUkt.class);
                siUkt1.setSyono("17809000104");
                siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
                siUkt1.setUktsyurenno(1);
                siUkt1.setUktnmkn("かかＡ");
                JT_SiUkt siUkt2 = SWAKInjector.getInstance(JT_SiUkt.class);
                siUkt2.setSyono("17809000104");
                siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
                siUkt2.setUktsyurenno(1);
                siUkt2.setUktnmkn("かかＢ");

                List<JT_SiUkt> siUktsList = new ArrayList<>();
                siUktsList.add(siUkt1);
                siUktsList.add(siUkt2);
                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn1);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihon.setSiUkts(siUktsList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN9.equals(SYORIPTN)) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000115");
                siKykKihon.setHksknnkaisiymd(null);
                siKykKihon.setTsinyno("1234567");

                JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn1.setSyono("17809000115");
                siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn1.setSyouhncd("W127");
                siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn1.setSyouhnsdno(10);
                siKykSyouhn1.setKyksyouhnrenno(1);
                siKykSyouhn1.setSyouhnnm("商品名");
                siKykSyouhn1.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn1.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);
                siKykSyouhn1.setSknnkaisiymd(BizDate.valueOf("20150506"));
                JT_SiKykSyouhn siKykSyouhn2 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn2.setSyono("17809000115");
                siKykSyouhn2.setSyutkkbn(C_SyutkKbn.TK);
                siKykSyouhn2.setSyouhncd("W128");
                siKykSyouhn2.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn2.setSyouhnsdno(10);
                siKykSyouhn2.setKyksyouhnrenno(1);
                siKykSyouhn2.setSyouhnnm("商品名");
                siKykSyouhn2.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn2.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn2.setKyktuukasyu(C_Tuukasyu.JPY);
                siKykSyouhn2.setSknnkaisiymd(BizDate.valueOf("20150506"));

                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn1);
                SiKykSyouhnList.add(siKykSyouhn2);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN10.equals(SYORIPTN)
                && "17809000034".equals(pKp.getSyono())) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000034");
                siKykKihon.setTsinyno("1234567");

                JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn1.setSyono("17809000034");
                siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn1.setSyouhncd("W102");
                siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn1.setSyouhnsdno(10);
                siKykSyouhn1.setKyksyouhnrenno(1);
                siKykSyouhn1.setSyouhnnm("商品名");
                siKykSyouhn1.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn1.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);

                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn1);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN10.equals(SYORIPTN)
                && "17809000171".equals(pKp.getSyono())) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000171");
                siKykKihon.setTsinyno("1234567");

                JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn1.setSyono("17809000171");
                siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn1.setSyouhncd("AA01");
                siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn1.setSyouhnsdno(10);
                siKykSyouhn1.setKyksyouhnrenno(1);
                siKykSyouhn1.setSyouhnnm("商品名");
                siKykSyouhn1.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn1.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);

                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn1);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN10.equals(SYORIPTN)
                && "17809000182".equals(pKp.getSyono())) {
                JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                siKykKihon.setSyono("17809000182");
                siKykKihon.setTsinyno("1234567");

                JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                siKykSyouhn1.setSyono("17809000182");
                siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                siKykSyouhn1.setSyouhncd("BA01");
                siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                siKykSyouhn1.setSyouhnsdno(10);
                siKykSyouhn1.setKyksyouhnrenno(1);
                siKykSyouhn1.setSyouhnnm("商品名");
                siKykSyouhn1.setSyouhnnmgm("商品名（画面用）");
                siKykSyouhn1.setSyouhnnmtyhy("商品名（帳票用）");
                siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.JPY);

                List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                SiKykSyouhnList.add(siKykSyouhn1);
                List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                siKykKihonList.add(siKykKihon);
                this.siKykKihonLst = siKykKihonList;
                return;
            }
            if (TESTPATTERN11.equals(SYORIPTN)) {
                if ("17809000182".equals(pKp.getSyono())) {

                    JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                    siKykKihon.setSyono("17809000182");
                    siKykKihon.setTsinyno("1234567");
                    siKykKihon.setDrtencd("1233");
                    siKykKihon.setKykhnkkaisuu(2);
                    siKykKihon.setHksknnkaisiymd(BizDate.valueOf(20160708));

                    JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                    siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                    siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                    siKykSyouhn1.setSyouhncd("HH01");
                    siKykSyouhn1.setSyouhnsdno(10);
                    siKykSyouhn1.setKykymd(BizDate.valueOf(20160506));
                    siKykSyouhn1.setYendthnkymd(BizDate.valueOf(20150506));
                    siKykSyouhn1.setTmttknitenymd(BizDate.valueOf(20190506));
                    siKykSyouhn1.setDai1hknkkn(11);

                    List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                    SiKykSyouhnList.add(siKykSyouhn1);
                    List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                    siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                    siKykKihonList.add(siKykKihon);
                    this.siKykKihonLst = siKykKihonList;
                }
                else if ("11810111381".equals(pKp.getSyono())) {

                    JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                    siKykKihon.setSyono("11810111381");
                    siKykKihon.setTsinyno("1234567");
                    siKykKihon.setDrtencd("1233");

                    JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                    siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                    siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                    siKykSyouhn1.setSyouhncd("HH01");
                    siKykSyouhn1.setSyouhnsdno(10);
                    siKykSyouhn1.setYendthnkymd(null);

                    List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                    SiKykSyouhnList.add(siKykSyouhn1);
                    List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                    siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                    siKykKihonList.add(siKykKihon);
                    this.siKykKihonLst = siKykKihonList;
                }
                else if ("11807111369".equals(pKp.getSyono())) {

                    JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                    siKykKihon.setSyono("11807111369");
                    siKykKihon.setTsinyno("1234567");

                    JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                    siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                    siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                    siKykSyouhn1.setSyouhncd("HH02");
                    siKykSyouhn1.setSyouhnsdno(10);

                    List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                    SiKykSyouhnList.add(siKykSyouhn1);
                    List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                    siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                    siKykKihonList.add(siKykKihon);
                    this.siKykKihonLst = siKykKihonList;
                }
                else if ("11807111370".equals(pKp.getSyono())) {

                    JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
                    siKykKihon.setSyono("11807111370");
                    siKykKihon.setTsinyno("1234567");

                    JT_SiKykSyouhn siKykSyouhn1 = siKykKihon.createSiKykSyouhn();
                    siKykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
                    siKykSyouhn1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
                    siKykSyouhn1.setSyouhncd("HH03");
                    siKykSyouhn1.setSyouhnsdno(10);

                    List<JT_SiKykSyouhn> SiKykSyouhnList = new ArrayList<>();
                    SiKykSyouhnList.add(siKykSyouhn1);
                    List<JT_SiKykKihon> siKykKihonList = new ArrayList<>();
                    siKykKihon.setSiKykSyouhns(SiKykSyouhnList);
                    siKykKihonList.add(siKykKihon);
                    this.siKykKihonLst = siKykKihonList;
                }
                return;
            }
        }
        super.getInfos(pKp);
    }

    @Override
    public List<JT_SiKykKihon> getKykKihons() {
        if (caller == CheckSbSkNaiyouTest_exec.class) {
            return siKykKihonLst;
        }
        return super.getKykKihons();
    }

}
