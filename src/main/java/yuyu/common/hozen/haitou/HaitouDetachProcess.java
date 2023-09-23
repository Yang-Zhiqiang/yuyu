package yuyu.common.hozen.haitou;

import java.util.List;
import java.util.Set;

import yuyu.def.db.mapping.AbstractExDBEntity;

/**
 * 契約保全 配当 配当デタッチ処理インターフェース
 */
public interface HaitouDetachProcess {

    public <T> T getInjectInstance(Class<T> pType);

    boolean getCollectEntityFlg();

    public void setEntity(AbstractExDBEntity<?, ?> entity);

    public void setEntity(List<? extends AbstractExDBEntity<?, ?>> entityList);

    public void collectEntity(boolean flg);

    public Set<AbstractExDBEntity<?, ?>> giveEntity();

    public void detach();
}
