package yuyu.infr.batchweb.interceptors;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.message.MessageManager;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_OrderStatusuKbn;
import yuyu.def.db.entity.AS_BatchOrder;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 全てのオンライン起動バッチの処理します。
 */
public class ClientInterceptor implements MethodInterceptor {

    public static final ClientInterceptor INSTANCE = new ClientInterceptor();

    private ClientInterceptor() {
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        try {
            preExecute(invocation);
            return invocation.proceed();
        } catch (Throwable th) {
            throw th;
        } finally {
        }
    }

    private static void preExecute(MethodInvocation invocation) throws Exception {

        boolean appointmentFlg = false;

        String orderTime = "0";

        if (invocation.getStaticPart() == null || invocation.getStaticPart().toString().length() == 0
            || invocation.getStaticPart().toString().indexOf("Action") == -1) {
            return;
        }

        C_KahiKbn kinouMode = null;

        BaseDomManager baseDomManager = SWAKInjector
            .getInstance(BaseDomManager.class);

        @Nullable
        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        if(kinou == null){
            return;
        }

        Set<AS_KinouMode> kinouModeList = kinou.getKinouModes();

        String kinouModeId = SWAKInjector.getInstance(KinouMode.class)
            .getKinouMode();
        for (AS_KinouMode entity : kinouModeList) {
            if (entity.getKinouModeId().equals(kinouModeId)) {
                kinouMode = entity.getBatchHeisouKahiKbn();
                break;
            }
        }

        if (kinouModeList.size() <= 0
            || C_KahiKbn.KA.eq(kinouMode)) {
            return;
        }

        List<AS_BatchOrder> batchOrderList = baseDomManager
            .getBatchOrderList();

        if (batchOrderList == null || batchOrderList.size() == 0) {
            return;
        }

        for (AS_BatchOrder batchOrder : batchOrderList) {

            if (C_OrderStatusuKbn.EXECUTE.eq(batchOrder.getOrderStatus())) {
                throw new BizLogicException(MessageId.EAS0038);
            } else if (C_OrderStatusuKbn.APPOINTMENT.eq(batchOrder
                .getOrderStatus())) {

                if (Long.parseLong(batchOrder.getOrderTime()) > Long.parseLong(orderTime)) {
                    orderTime = batchOrder.getOrderTime();
                }
                appointmentFlg = true;
            }
        }
        if (appointmentFlg) {
            SWAKInjector.getInstance(MessageManager.class).addMessageId(MessageId.WAS0001,
                getSystemDate17(orderTime), String.valueOf(YuyuBaseConfig
                    .getInstance().getBatchRetryWaitTime() / 1000));
        }
    }

    private static String getSystemDate17(String orderTime) throws ParseException {
        SimpleDateFormat formatIn = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        SimpleDateFormat formatOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return formatOut.format(formatIn.parse(orderTime));
        } catch (ParseException e) {
            throw e;
        }
    }

}
