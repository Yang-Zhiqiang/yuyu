package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.mapping.GenBM_Channel;


/**
 * チャネルマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Channel} の JavaDoc を参照してください。<br />
 * @see     GenBM_Channel<br />
 * @see     PKBM_Channel<br />
 * @see     QBM_Channel<br />
 * @see     GenQBM_Channel<br />
 */
@Entity
public class BM_Channel extends GenBM_Channel {

    private static final long serialVersionUID = 1L;

    public BM_Channel() {
    }

    public BM_Channel(C_Channelcd pChannelcd) {
        super(pChannelcd);
    }



    private BM_Tyouhyourenrakusaki bM_Tyouhyourenrakusaki ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BM_Channel.TYHYRENRAKUSIKIBETUKBN  , referencedColumnName=BM_Tyouhyourenrakusaki.TYHYRENRAKUSIKIBETUKBN, insertable=false, updatable=false)
    })
    public  BM_Tyouhyourenrakusaki getTyouhyourenrakusaki() {
        return bM_Tyouhyourenrakusaki;
    }

    public void setTyouhyourenrakusaki(BM_Tyouhyourenrakusaki pBM_Tyouhyourenrakusaki) {
        this.bM_Tyouhyourenrakusaki = pBM_Tyouhyourenrakusaki;
    }

}

