package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.mapping.GenBM_ChkTkykHukaKahi;


/**
 * 特約付加可否倍率チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkTkykHukaKahi} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkTkykHukaKahi<br />
 * @see     PKBM_ChkTkykHukaKahi<br />
 * @see     QBM_ChkTkykHukaKahi<br />
 * @see     GenQBM_ChkTkykHukaKahi<br />
 */
@Entity
public class BM_ChkTkykHukaKahi extends GenBM_ChkTkykHukaKahi {

    private static final long serialVersionUID = 1L;

    public BM_ChkTkykHukaKahi() {
    }

    public BM_ChkTkykHukaKahi(String pTksyouhncd,String pSyusyouhncd,Integer pSyusyouhnsdnofrom,Integer pSyusyouhnsdnoto,C_Channelcd pChannelcd) {
        super(pTksyouhncd,pSyusyouhncd,pSyusyouhnsdnofrom,pSyusyouhnsdnoto,pChannelcd);
    }



}

