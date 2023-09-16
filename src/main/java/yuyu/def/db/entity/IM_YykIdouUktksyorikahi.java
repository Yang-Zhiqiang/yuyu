package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIM_YykIdouUktksyorikahi;


/**
 * 予約異動受付中処理可否マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIM_YykIdouUktksyorikahi} の JavaDoc を参照してください。<br />
 * @see     GenIM_YykIdouUktksyorikahi<br />
 * @see     PKIM_YykIdouUktksyorikahi<br />
 * @see     QIM_YykIdouUktksyorikahi<br />
 * @see     GenQIM_YykIdouUktksyorikahi<br />
 */
@Entity
public class IM_YykIdouUktksyorikahi extends GenIM_YykIdouUktksyorikahi {

    private static final long serialVersionUID = 1L;

    public IM_YykIdouUktksyorikahi() {
    }

    public IM_YykIdouUktksyorikahi(String pKinouId,String pYykuktkkinouid) {
        super(pKinouId,pYykuktkkinouid);
    }



}

