CREATE VIEW MV_MailAddressRenbanSaisin AS SELECT
    t1.dskokno,                /* DS顧客番号 */
    t1.dsmailaddressrenban,    /* DSメールアドレス連番 */
    t2.kousinsyaId,            /* 更新者ＩＤ */
    t2.kousinTime,             /* 更新時間 */
    t2.kousinKinou,            /* 更新機能 */
    t2.version                 /* バージョン */
FROM (
    SELECT 
        dskokno,                                           /* DS顧客番号 */
        MAX(dsmailaddressrenban) AS dsmailaddressrenban    /* DSメールアドレス連番の最大 */
    FROM MT_DsMailAddress 
    GROUP BY dskokno) t1
INNER JOIN (
    SELECT 
        dskokno,               /* DS顧客番号 */
        dsmailaddressrenban,   /* DSメールアドレス連番 */
        kousinsyaId,           /* 更新者ＩＤ */
        kousinTime,            /* 更新時間 */
        kousinKinou,           /* 更新機能 */
        version                /* バージョン */
    FROM MT_DsMailAddress) t2
ON t1.dskokno = t2.dskokno 
AND t1.dsmailaddressrenban = t2.dsmailaddressrenban;