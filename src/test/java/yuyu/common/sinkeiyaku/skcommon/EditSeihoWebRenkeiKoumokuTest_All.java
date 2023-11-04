package yuyu.common.sinkeiyaku.skcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.testinfr.AbstractTest;

/**
 * {@link EditSeihoWebRenkeiKoumoku}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({
    EditSeihoWebRenkeiKoumokuTest_adr1Syutoku.class,
    EditSeihoWebRenkeiKoumokuTest_adr2Syutoku.class,
    EditSeihoWebRenkeiKoumokuTest_adr3Syutoku.class,
    EditSeihoWebRenkeiKoumokuTest_gaikanykntkhkkbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_haitoukinuketorihoukbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_hhknseiHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_huho2EditHknsyuruino.class,
    EditSeihoWebRenkeiKoumokuTest_hrkkaisuuHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_hrkkeiroHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_fstphrkkeiroHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_hrkkknsmnkbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_mossyukykpSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_kakukisyouryakukbumukbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_kihonsSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_kinmusakinmSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_kjmeigihkhunouumukbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_ktninSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_kykkbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_kykkbnkyktdkkbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_kykseiHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_mojiretukiritori.class,
    EditSeihoWebRenkeiKoumokuTest_mosnoHensyuu.class,
    EditSeihoWebRenkeiKoumokuTest_nstkhkkbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_postalCdSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_seiymdmosseitouumukbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_sntkhoukbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_sntkhouKbnsyokugyouHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_syosisyatodokeumukbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_targettkhkkbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_targettkkbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_targettkmkhtkbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_tsbjFkmrrHantei.class,
    EditSeihoWebRenkeiKoumokuTest_tsryhshrkykumukbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_tuukasyuHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_tuukaKbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_uktkbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_uktnmkjSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_uktnmknSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_uktseiymdSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_ukttdkSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_yennykntkhkkbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_syksbYensitiHsyuTkhkKbn.class,
    EditSeihoWebRenkeiKoumokuTest_jyudKaigoMehrTkhkKbn.class,
    EditSeihoWebRenkeiKoumokuTest_zrnKykTdkKbn.class,
    EditSeihoWebRenkeiKoumokuTest_zrnUktTdkKbn.class,
    EditSeihoWebRenkeiKoumokuTest_tumitatekinHaibunWariKbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_dsSyomenTtdkHyoujiHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_sknenkinsyuHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_kouzasyuruiKbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_yokinKbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_hknkknSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_huho2GetMosheijyunp.class,
    EditSeihoWebRenkeiKoumokuTest_huho2GetIkkatubaraikbn.class,
    EditSeihoWebRenkeiKoumokuTest_huho2GetIkkatubaraikaisuu.class,
    EditSeihoWebRenkeiKoumokuTest_huho2GetMosikkatup.class,
    EditSeihoWebRenkeiKoumokuTest_huho2GetZennoumousideumu.class,
    EditSeihoWebRenkeiKoumokuTest_huho2GetZenkizennouumu.class,
    EditSeihoWebRenkeiKoumokuTest_huho2GetZnnkai.class,
    EditSeihoWebRenkeiKoumokuTest_huho2GetMoszennoup.class,
    EditSeihoWebRenkeiKoumokuTest_huho2GetKjnnkpzeitekitkhukakbn.class,
    EditSeihoWebRenkeiKoumokuTest_huho2GetPplsrendoukouhurikousoukbn.class,
    EditSeihoWebRenkeiKoumokuTest_huho2GetPplessrendoucreditkousoukbn.class,
    EditSeihoWebRenkeiKoumokuTest_seihoWebGetPwaribikirankkbn.class,
    EditSeihoWebRenkeiKoumokuTest_huho2GetYakkanJyuryouKbn.class,
    EditSeihoWebRenkeiKoumokuTest_mosymdHensyuu.class,
    EditSeihoWebRenkeiKoumokuTest_kzkSeibetuHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_tsindousiteikbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_kzktourokumoskbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_kzktdkkbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_hhkdrtdkkbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_kykdruktkbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_kykdrtkykhukakbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_hhkdrtkykhukakbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_kzhuritourokuhoukbnHenkan.class,
    EditSeihoWebRenkeiKoumokuTest_teikisiharaitkykhkkbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_koureikzksetumeihoukbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_syouhnhantei.class,
    EditSeihoWebRenkeiKoumokuTest_hhknnensyuukbnSyutoku.class,
    EditSeihoWebRenkeiKoumokuTest_ptuutihyjHenkan.class

})
public class EditSeihoWebRenkeiKoumokuTest_All extends AbstractTest {

}
