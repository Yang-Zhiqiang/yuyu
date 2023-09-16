package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenHT_BAK_SkDenpyoData;


/**
 * 新契約伝票データバックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_BAK_SkDenpyoData} の JavaDoc を参照してください。<br />
 * @see     GenHT_BAK_SkDenpyoData<br />
 * @see     PKHT_BAK_SkDenpyoData<br />
 * @see     QHT_BAK_SkDenpyoData<br />
 * @see     GenQHT_BAK_SkDenpyoData<br />
 */
@Entity
public class HT_BAK_SkDenpyoData extends GenHT_BAK_SkDenpyoData {

    private static final long serialVersionUID = 1L;

    public HT_BAK_SkDenpyoData() {
    }

    public HT_BAK_SkDenpyoData(String pDenrenno,String pTrkssikibetukey,Integer pEdano) {
        super(pDenrenno,pTrkssikibetukey,pEdano);
    }



    private HT_BAK_SyoriCTL hT_BAKSyoriCTL ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=HT_BAK_SkDenpyoData.TRKSSIKIBETUKEY  , referencedColumnName=HT_BAK_SyoriCTL.TRKSSIKIBETUKEY, insertable=false, updatable=false),
        @JoinColumn(name=HT_BAK_SkDenpyoData.SYONO  , referencedColumnName=HT_BAK_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public  HT_BAK_SyoriCTL getBAKSyoriCTL() {
        return hT_BAKSyoriCTL;
    }

    public void setBAKSyoriCTL(HT_BAK_SyoriCTL pHT_BAK_SyoriCTL) {
        this.hT_BAKSyoriCTL = pHT_BAK_SyoriCTL;
    }

}

