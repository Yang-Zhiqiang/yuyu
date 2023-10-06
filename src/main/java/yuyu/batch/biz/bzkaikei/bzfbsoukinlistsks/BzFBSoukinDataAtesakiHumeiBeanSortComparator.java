package yuyu.batch.biz.bzkaikei.bzfbsoukinlistsks;

import java.util.Comparator;

import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_YokinKbn;

/**
 * 【ＦＢ送金リスト作成】CreatFBSoukinLstBeanをソートするためのコンパレータです。<br />
 * ソート条件は｛ＦＢ送金リスト管理マスタ（宛先不明）．ＦＢ明細書類コードの（昇順）
 *               ＦＢ送金リスト管理マスタ（宛先不明）．担当室コードの（昇順）
 *               ＦＢ送金リスト用データ（宛先不明）．支払方法指定区分の（昇順）
 *               ＦＢ送金リスト用データBEAN（宛先不明）．送金不可銀行分（降順）
 *               ＦＢ送金リスト用データ（宛先不明）．業務コードの（昇順）
 *               ＦＢ送金リスト用データ（宛先不明）．銀行コードの（昇順）
 *               ＦＢ送金リスト用データ（宛先不明）．支店コードの（昇順）
 *               ＦＢ送金リスト用データ（宛先不明）．預金種目区分の（昇順）
 *               ＦＢ送金リスト用データ（宛先不明）．口座番号の（昇順）
 *               ＦＢ送金リスト用データ（宛先不明）．口座名義人氏名（カナ）の（昇順）
 *               ＦＢ送金リスト用データ（宛先不明）．経理用証券番号の（昇順）
 *               ｝です
 */
public class BzFBSoukinDataAtesakiHumeiBeanSortComparator implements Comparator<BzFBSoukinDataAtesakiHumeiBean> {

    @Override
    public int compare(BzFBSoukinDataAtesakiHumeiBean o1, BzFBSoukinDataAtesakiHumeiBean o2) {

        C_SyoruiCdKbn  fbmeisaisyoruicd1 = o1.getFBSoukinListKanriAtesakiHumei().getFbmeisaisyoruicd() == null ?
            C_SyoruiCdKbn.BLNK : o1.getFBSoukinListKanriAtesakiHumei().getFbmeisaisyoruicd();
        C_SyoruiCdKbn  fbmeisaisyoruicd2 = o2.getFBSoukinListKanriAtesakiHumei().getFbmeisaisyoruicd() == null ?
            C_SyoruiCdKbn.BLNK : o2.getFBSoukinListKanriAtesakiHumei().getFbmeisaisyoruicd();

        C_Tantositucd tantositucd1 = o1.getFBSoukinListKanriAtesakiHumei().getTantositucd() == null ?
            C_Tantositucd.BLNK0 : o1.getFBSoukinListKanriAtesakiHumei().getTantositucd();
        C_Tantositucd tantositucd2 = o2.getFBSoukinListKanriAtesakiHumei().getTantositucd() == null ?
            C_Tantositucd.BLNK0 : o2.getFBSoukinListKanriAtesakiHumei().getTantositucd();

        C_ShrhousiteiKbn shrhousiteiKbn1 = o1.getFBSoukinDataAtesakiHumei().getShrhousiteikbn() == null ?
            C_ShrhousiteiKbn.BLNK : o1.getFBSoukinDataAtesakiHumei().getShrhousiteikbn();
        C_ShrhousiteiKbn shrhousiteiKbn2 = o2.getFBSoukinDataAtesakiHumei().getShrhousiteikbn() == null ?
            C_ShrhousiteiKbn.BLNK : o2.getFBSoukinDataAtesakiHumei().getShrhousiteikbn();

        String soukinHukaBank1 = o1.getSoukinHukaBank() == null ? "" : o1.getSoukinHukaBank();
        String soukinHukaBank2 = o2.getSoukinHukaBank() == null ? "" : o2.getSoukinHukaBank();

        C_Gyoumucd  irGyoumucd1 = o1.getFBSoukinDataAtesakiHumei().getGyoumucd() == null ?
            C_Gyoumucd.BLNK : o1.getFBSoukinDataAtesakiHumei().getGyoumucd();
        C_Gyoumucd  irGyoumucd2 = o2.getFBSoukinDataAtesakiHumei().getGyoumucd() == null ?
            C_Gyoumucd.BLNK : o2.getFBSoukinDataAtesakiHumei().getGyoumucd();

        String bankcd1 = o1.getFBSoukinDataAtesakiHumei().getBankcd() == null ? "" : o1.getFBSoukinDataAtesakiHumei().getBankcd();
        String bankcd2 = o2.getFBSoukinDataAtesakiHumei().getBankcd() == null ? "" : o2.getFBSoukinDataAtesakiHumei().getBankcd();

        String sitencd1 = o1.getFBSoukinDataAtesakiHumei().getSitencd() == null ? "" : o1.getFBSoukinDataAtesakiHumei().getSitencd();
        String sitencd2 = o2.getFBSoukinDataAtesakiHumei().getSitencd() == null ? "" : o2.getFBSoukinDataAtesakiHumei().getSitencd();

        C_YokinKbn yokinKbn1  = o1.getFBSoukinDataAtesakiHumei().getYokinkbn() == null ?
            C_YokinKbn.BLNK : o1.getFBSoukinDataAtesakiHumei().getYokinkbn();
        C_YokinKbn yokinKbn2  = o2.getFBSoukinDataAtesakiHumei().getYokinkbn() == null ?
            C_YokinKbn.BLNK : o2.getFBSoukinDataAtesakiHumei().getYokinkbn();

        String kouzano1 = o1.getFBSoukinDataAtesakiHumei().getKouzano() == null ? "" : o1.getFBSoukinDataAtesakiHumei().getKouzano();
        String kouzano2 = o2.getFBSoukinDataAtesakiHumei().getKouzano() == null ? "" : o2.getFBSoukinDataAtesakiHumei().getKouzano();

        String Kzmeiginmkn1 = o1.getFBSoukinDataAtesakiHumei().getKzmeiginmkn() == null ?
            "" : o1.getFBSoukinDataAtesakiHumei().getKzmeiginmkn();
        String Kzmeiginmkn2 = o2.getFBSoukinDataAtesakiHumei().getKzmeiginmkn() == null ?
            "" : o2.getFBSoukinDataAtesakiHumei().getKzmeiginmkn();

        String keirisyono1 = o1.getFBSoukinDataAtesakiHumei().getKeirisyono() == null ?
            "" : o1.getFBSoukinDataAtesakiHumei().getKeirisyono();
        String keirisyono2 = o2.getFBSoukinDataAtesakiHumei().getKeirisyono() == null ?
            "" : o2.getFBSoukinDataAtesakiHumei().getKeirisyono();

        int cmpret = 0;

        if(!fbmeisaisyoruicd1.equals(fbmeisaisyoruicd2)) {

            if(C_SyoruiCdKbn .BLNK.eq(fbmeisaisyoruicd1)) {
                return -1;
            }
            if(C_SyoruiCdKbn .BLNK.eq(fbmeisaisyoruicd2)) {
                return 1;
            }

            cmpret = fbmeisaisyoruicd1.compareTo(fbmeisaisyoruicd2);

        }
        else{

            if(!tantositucd1.equals(tantositucd2)) {

                if(C_Tantositucd.BLNK0.eq(tantositucd1)) {
                    return -1;
                }
                if(C_Tantositucd.BLNK0.eq(tantositucd2)) {
                    return 1;
                }

                cmpret =  tantositucd1.compareTo(tantositucd2);

            }
            else {
                if(!shrhousiteiKbn1.equals(shrhousiteiKbn2)) {

                    if(C_ShrhousiteiKbn.BLNK.eq(shrhousiteiKbn1)) {
                        return -1;
                    }
                    if(C_ShrhousiteiKbn.BLNK.eq(shrhousiteiKbn2)) {
                        return 1;
                    }

                    cmpret =  shrhousiteiKbn1.compareTo(shrhousiteiKbn2);
                }
                else {
                    if(!soukinHukaBank1.equals(soukinHukaBank2)) {

                        if("".equals(soukinHukaBank2)) {
                            return 1;
                        }
                        if("".equals(soukinHukaBank1)) {
                            return -1;
                        }

                        cmpret =  soukinHukaBank2.compareTo(soukinHukaBank1);
                    }
                    else {
                        if(!irGyoumucd1.equals(irGyoumucd2)) {

                            if(C_Gyoumucd.BLNK.eq(irGyoumucd1)) {
                                return -1;
                            }
                            if(C_Gyoumucd.BLNK.eq(irGyoumucd2)) {
                                return 1;
                            }

                            cmpret =  irGyoumucd1.compareTo(irGyoumucd2);
                        }
                        else {
                            if(!bankcd1.equals(bankcd2)) {

                                if("".equals(bankcd1)) {
                                    return -1;
                                }
                                if("".equals(bankcd2)) {
                                    return 1;
                                }

                                cmpret =  bankcd1.compareTo(bankcd2);
                            }
                            else {
                                if(!sitencd1.equals(sitencd2)) {

                                    if("".equals(sitencd1)) {
                                        return -1;
                                    }
                                    if("".equals(sitencd2)) {
                                        return 1;
                                    }

                                    cmpret =  sitencd1.compareTo(sitencd2);
                                }
                                else {
                                    if(!yokinKbn1.equals(yokinKbn2)) {

                                        if(C_YokinKbn.BLNK.eq(yokinKbn1)) {
                                            return -1;
                                        }
                                        if(C_YokinKbn.BLNK.eq(yokinKbn2)) {
                                            return 1;
                                        }

                                        cmpret =  yokinKbn1.compareTo(yokinKbn2);
                                    }
                                    else {
                                        if(!kouzano1.equals(kouzano2)) {

                                            if("".equals(kouzano1)) {
                                                return -1;
                                            }
                                            if("".equals(kouzano2)) {
                                                return 1;
                                            }

                                            cmpret =  kouzano1.compareTo(kouzano2);
                                        }
                                        else {
                                            if(!Kzmeiginmkn1.equals(Kzmeiginmkn2)) {

                                                if("".equals(Kzmeiginmkn1)) {
                                                    return -1;
                                                }
                                                if("".equals(Kzmeiginmkn2)) {
                                                    return 1;
                                                }

                                                cmpret =  Kzmeiginmkn1.compareTo(Kzmeiginmkn2);
                                            }
                                            else {
                                                if(!keirisyono1.equals(keirisyono2)) {

                                                    if("".equals(keirisyono1)) {
                                                        return -1;
                                                    }
                                                    if("".equals(keirisyono2)) {
                                                        return 1;
                                                    }

                                                    cmpret =  keirisyono1.compareTo(keirisyono2);
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
