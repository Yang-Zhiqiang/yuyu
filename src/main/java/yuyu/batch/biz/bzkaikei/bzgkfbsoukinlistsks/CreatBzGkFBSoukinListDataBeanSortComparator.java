package yuyu.batch.biz.bzkaikei.bzgkfbsoukinlistsks;

import java.util.Comparator;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 【外貨ＦＢ送金リスト用データBEAN（宛先不明）リスト】BzGkFBSoukinListDataBeanをソートするためのコンパレータです。<br />
 * ソート条件は
 * ｛ＦＢ明細書類コードの昇順、担当室コードの昇順、支払方法指定区分の昇順、伝票日付、外貨業務コード、契約通貨種類、
 *  銀行コード、支店コード、口座番号、口座名義人氏名（英字）、経理用証券番号の昇順｝です。
 */
public class CreatBzGkFBSoukinListDataBeanSortComparator implements Comparator<BzGkFBSoukinListDataBean> {

    @Override
    public int compare(BzGkFBSoukinListDataBean o1, BzGkFBSoukinListDataBean o2) {

        C_SyoruiCdKbn fbmeisaisyoruicd1 = o1.getBmFBSoukinListKanri().getGkfbmeisaisyoruicd() == null ?
            C_SyoruiCdKbn.BLNK : o1.getBmFBSoukinListKanri().getGkfbmeisaisyoruicd();

        C_SyoruiCdKbn fbmeisaisyoruicd2 = o2.getBmFBSoukinListKanri().getGkfbmeisaisyoruicd() == null ?
            C_SyoruiCdKbn.BLNK : o2.getBmFBSoukinListKanri().getGkfbmeisaisyoruicd();

        C_Tantositucd tantositucd1 = o1.getBmFBSoukinListKanri().getTantositucd() == null ?
            C_Tantositucd.BLNK0 : o1.getBmFBSoukinListKanri().getTantositucd();

        C_Tantositucd tantositucd2 = o2.getBmFBSoukinListKanri().getTantositucd() == null ?
            C_Tantositucd.BLNK0 : o2.getBmFBSoukinListKanri().getTantositucd();

        C_ShrhousiteiKbn shrhousiteikbn1 = o1.getBtGkFBSoukinData().getShrhousiteikbn() == null ?
            C_ShrhousiteiKbn.BLNK : o1.getBtGkFBSoukinData().getShrhousiteikbn();

        C_ShrhousiteiKbn shrhousiteikbn2 = o2.getBtGkFBSoukinData().getShrhousiteikbn() == null ?
            C_ShrhousiteiKbn.BLNK : o2.getBtGkFBSoukinData().getShrhousiteikbn();

        BizDate denymd1 = o1.getBtGkFBSoukinData().getDenymd() == null ?
            BizDate.MIN_VALUE : o1.getBtGkFBSoukinData().getDenymd();

        BizDate denymd2 = o2.getBtGkFBSoukinData().getDenymd() == null ?
            BizDate.MIN_VALUE : o2.getBtGkFBSoukinData().getDenymd();

        C_Gkgyoumucd gkgyoumucd1 = o1.getBtGkFBSoukinData().getGkgyoumucd() == null ?
            C_Gkgyoumucd.BLNK : o1.getBtGkFBSoukinData().getGkgyoumucd();

        C_Gkgyoumucd gkgyoumucd2 = o2.getBtGkFBSoukinData().getGkgyoumucd() == null ?
            C_Gkgyoumucd.BLNK : o2.getBtGkFBSoukinData().getGkgyoumucd();

        C_Tuukasyu kyktuukasyu1 = o1.getBtGkFBSoukinData().getKyktuukasyu() == null ?
            C_Tuukasyu.BLNK : o1.getBtGkFBSoukinData().getKyktuukasyu();

        C_Tuukasyu kyktuukasyu2 = o2.getBtGkFBSoukinData().getKyktuukasyu() == null ?
            C_Tuukasyu.BLNK : o2.getBtGkFBSoukinData().getKyktuukasyu();

        String bankcd1 = o1.getBtGkFBSoukinData().getBankcd() == null ?
            "" : o1.getBtGkFBSoukinData().getBankcd();

        String bankcd2 = o2.getBtGkFBSoukinData().getBankcd() == null ?
            "" : o2.getBtGkFBSoukinData().getBankcd();

        String sitencd1 = o1.getBtGkFBSoukinData().getSitencd() == null ?
            "" : o1.getBtGkFBSoukinData().getSitencd();

        String sitencd2 = o2.getBtGkFBSoukinData().getSitencd() == null ?
            "" : o2.getBtGkFBSoukinData().getSitencd();

        String kouzano1 = o1.getBtGkFBSoukinData().getKouzano() == null ?
            "" : o1.getBtGkFBSoukinData().getKouzano();

        String kouzano2 = o2.getBtGkFBSoukinData().getKouzano() == null ?
            "" : o2.getBtGkFBSoukinData().getKouzano();

        String kzmeiginmei1 = o1.getBtGkFBSoukinData().getKzmeiginmei() == null ?
            "" : o1.getBtGkFBSoukinData().getKzmeiginmei();

        String kzmeiginmei2 = o2.getBtGkFBSoukinData().getKzmeiginmei() == null ?
            "" : o2.getBtGkFBSoukinData().getKzmeiginmei();

        String keirisyono1 = o1.getBtGkFBSoukinData().getKeirisyono() == null ?
            "" : o1.getBtGkFBSoukinData().getKeirisyono();

        String keirisyono2 = o2.getBtGkFBSoukinData().getKeirisyono() == null ?
            "" : o2.getBtGkFBSoukinData().getKeirisyono();

        int cmpret = 0;

        if (!fbmeisaisyoruicd1.equals(fbmeisaisyoruicd2)) {

            if (C_SyoruiCdKbn.BLNK.eq(fbmeisaisyoruicd1)) {
                return -1;
            }

            if (C_SyoruiCdKbn.BLNK.eq(fbmeisaisyoruicd2)) {
                return 1;
            }

            cmpret = fbmeisaisyoruicd1.compareTo(fbmeisaisyoruicd2);
        }
        else {

            if (!tantositucd1.equals(tantositucd2)) {

                if (C_Tantositucd.BLNK0.eq(tantositucd1)) {
                    return -1;
                }

                if (C_Tantositucd.BLNK0.eq(tantositucd2)) {
                    return 1;
                }

                cmpret = tantositucd1.compareTo(tantositucd2);
            }
            else {

                if (!shrhousiteikbn1.equals(shrhousiteikbn2)) {

                    if (C_ShrhousiteiKbn.BLNK.eq(shrhousiteikbn1)) {
                        return -1;
                    }

                    if (C_ShrhousiteiKbn.BLNK.eq(shrhousiteikbn2)) {
                        return 1;
                    }

                    cmpret = shrhousiteikbn1.compareTo(shrhousiteikbn2);
                }
                else {

                    if (!denymd1.equals(denymd2)) {

                        if (BizDate.MIN_VALUE.equals(denymd1)) {
                            return -1;
                        }

                        if (BizDate.MIN_VALUE.equals(denymd2)) {
                            return 1;
                        }

                        cmpret = denymd1.compareTo(denymd2);
                    }
                    else {

                        if (!gkgyoumucd1.equals(gkgyoumucd2)) {

                            if (C_Gkgyoumucd.BLNK.eq(gkgyoumucd1)) {
                                return -1;
                            }

                            if (C_Gkgyoumucd.BLNK.eq(gkgyoumucd2)) {
                                return 1;
                            }

                            cmpret = gkgyoumucd1.compareTo(gkgyoumucd2);
                        }
                        else {

                            if (!kyktuukasyu1.equals(kyktuukasyu2)) {

                                if (C_Tuukasyu.BLNK.eq(kyktuukasyu1)) {
                                    return -1;
                                }

                                if (C_Tuukasyu.BLNK.eq(kyktuukasyu2)) {
                                    return 1;
                                }

                                cmpret = kyktuukasyu1.compareTo(kyktuukasyu2);
                            }
                            else {

                                if (!bankcd1.equals(bankcd2)) {

                                    if ("".equals(bankcd1)) {
                                        return -1;
                                    }

                                    if ("".equals(bankcd2)) {
                                        return 1;
                                    }

                                    cmpret = bankcd1.compareTo(bankcd2);
                                }
                                else {

                                    if (!sitencd1.equals(sitencd2)) {

                                        if ("".equals(sitencd1)) {
                                            return -1;
                                        }

                                        if ("".equals(sitencd2)) {
                                            return 1;
                                        }

                                        cmpret = sitencd1.compareTo(sitencd2);
                                    }
                                    else {

                                        if (!kouzano1.equals(kouzano2)) {

                                            if ("".equals(kouzano1)) {
                                                return -1;
                                            }

                                            if ("".equals(kouzano2)) {
                                                return 1;
                                            }

                                            cmpret = kouzano1.compareTo(kouzano2);
                                        }
                                        else {

                                            if (!kzmeiginmei1.equals(kzmeiginmei2)) {

                                                if ("".equals(kzmeiginmei1)) {
                                                    return -1;
                                                }

                                                if ("".equals(kzmeiginmei2)) {
                                                    return 1;
                                                }

                                                cmpret = kzmeiginmei1.compareTo(kzmeiginmei2);
                                            }
                                            else {

                                                if (!keirisyono1.equals(keirisyono2)) {

                                                    if ("".equals(keirisyono1)) {
                                                        return -1;
                                                    }

                                                    if ("".equals(keirisyono2)) {
                                                        return 1;
                                                    }

                                                    cmpret = keirisyono1.compareTo(keirisyono2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return cmpret;
    }
}
