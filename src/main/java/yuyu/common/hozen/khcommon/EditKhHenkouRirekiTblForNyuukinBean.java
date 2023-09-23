package yuyu.common.hozen.khcommon;

import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;
import yuyu.def.db.entity.IT_Tokusin;

/**
 * 契約保全 契約保全共通 契約保全変更履歴TBL編集（入金用）Bean
 */
public class EditKhHenkouRirekiTblForNyuukinBean {

    private String henkouSikibetuKey;

    private IT_KykKihon kykKihonSyoriAto;

    private IT_AnsyuKihon ansyuKihonSyoriAto;

    private IT_NyuukinKakusyouData nyuukinKakusyouDataSyoriAto;

    private IT_AnsyuKihon ansyuKihonSyoriMae;

    private IT_KykSyouhn kykSyouhnSyoriMae;

    private IT_Kariukekin kariukekinSyoriAto;

    private IT_Tokusin tokusinSyoriMae;

    private IT_SyuunouHenknRireki syuunouHenknRirekiSyoriAto;

    public EditKhHenkouRirekiTblForNyuukinBean() {
        super();
    }

    public String getHenkouSikibetuKey() {
        return henkouSikibetuKey;
    }

    public void setHenkouSikibetuKey(String pHenkouSikibetuKey) {
        henkouSikibetuKey = pHenkouSikibetuKey;
    }

    public IT_KykKihon getKykKihonSyoriAto() {
        return kykKihonSyoriAto;
    }

    public void setKykKihonSyoriAto(IT_KykKihon pKykKihonSyoriAto) {
        kykKihonSyoriAto = pKykKihonSyoriAto;
    }

    public IT_AnsyuKihon getAnsyuKihonSyoriAto() {
        return ansyuKihonSyoriAto;
    }

    public void setAnsyuKihonSyoriAto(IT_AnsyuKihon pAnsyuKihonSyoriAto) {
        ansyuKihonSyoriAto = pAnsyuKihonSyoriAto;
    }

    public IT_NyuukinKakusyouData getNyuukinKakusyouDataSyoriAto() {
        return nyuukinKakusyouDataSyoriAto;
    }

    public void setNyuukinKakusyouDataSyoriAto(IT_NyuukinKakusyouData pNyuukinKakusyouDataSyoriAto) {
        nyuukinKakusyouDataSyoriAto = pNyuukinKakusyouDataSyoriAto;
    }

    public IT_AnsyuKihon getAnsyuKihonSyoriMae() {
        return ansyuKihonSyoriMae;
    }

    public void setAnsyuKihonSyoriMae(IT_AnsyuKihon pAnsyuKihonSyoriMae) {
        ansyuKihonSyoriMae = pAnsyuKihonSyoriMae;
    }

    public IT_KykSyouhn getKykSyouhnSyoriMae() {
        return kykSyouhnSyoriMae;
    }

    public void setKykSyouhnSyoriMae(IT_KykSyouhn pKykSyouhnSyoriMae) {
        kykSyouhnSyoriMae = pKykSyouhnSyoriMae;
    }

    public IT_Kariukekin getKariukekinSyoriAto() {
        return kariukekinSyoriAto;
    }

    public void setKariukekinSyoriAto(IT_Kariukekin pKariukekinSyoriAto) {
        kariukekinSyoriAto = pKariukekinSyoriAto;
    }

    public IT_Tokusin getTokusinSyoriMae() {
        return tokusinSyoriMae;
    }

    public void setTokusinSyoriMae(IT_Tokusin pTokusinSyoriMae) {
        tokusinSyoriMae = pTokusinSyoriMae;
    }

    public IT_SyuunouHenknRireki getSyuunouHenknRirekiSyoriAto() {
        return syuunouHenknRirekiSyoriAto;
    }

    public void setSyuunouHenknRirekiSyoriAto(IT_SyuunouHenknRireki pSyuunouHenknRirekiSyoriAto) {
        syuunouHenknRirekiSyoriAto = pSyuunouHenknRirekiSyoriAto;
    }
}
