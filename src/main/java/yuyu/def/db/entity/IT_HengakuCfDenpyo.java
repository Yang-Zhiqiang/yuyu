package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIT_HengakuCfDenpyo;


/**
 * 変額ＣＦ伝票テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_HengakuCfDenpyo} の JavaDoc を参照してください。<br />
 * @see     GenIT_HengakuCfDenpyo<br />
 * @see     PKIT_HengakuCfDenpyo<br />
 * @see     QIT_HengakuCfDenpyo<br />
 * @see     GenQIT_HengakuCfDenpyo<br />
 */
@Entity
public class IT_HengakuCfDenpyo extends GenIT_HengakuCfDenpyo {

    private static final long serialVersionUID = 1L;

    public IT_HengakuCfDenpyo() {
    }

    public IT_HengakuCfDenpyo(String pDenrenno,Integer pEdano) {
        super(pDenrenno,pEdano);
    }



}

