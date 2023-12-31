CREATE VIEW ZT_SmbcGetujiKykMeisaiRn AS SELECT
     zrndatakijyunymd ,         /* （連携用）データ基準年月日 */
     zrndatakijyunym ,         /* （連携用）データ基準年月 */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnaatukaidirtncd ,         /* （連携用）Ａ扱代理店コード */
     zrnbatukaidirtncd ,         /* （連携用）Ｂ扱代理店コード */
     zrnaatukaibosyuunincd ,         /* （連携用）Ａ扱募集人コード */
     zrnbatukaibosyuunincd ,         /* （連携用）Ｂ扱募集人コード */
     zrnhknsyukigou ,         /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn ,         /* （連携用）保険種類記号世代区分 */
     zrnmdhnaisyoumeicd ,         /* （連携用）窓販用愛称名コード */
     zrntuukacdsmbcgetuji ,         /* （連携用）通貨コード（ＳＭＢＣ月次契約Ｆ） */
     zrnhrkhuhukbn ,         /* （連携用）払込方法区分 */
     zrnkyknmknsmbcgetuji ,         /* （連携用）契約者名（カナ）（ＳＭＢＣ月次契約Ｆ） */
     zrnkyknmkjsmbcgetuji ,         /* （連携用）契約者名（漢字）（ＳＭＢＣ月次契約Ｆ） */
     zrnhhknnmkjsmbcgetuji ,         /* （連携用）被保険者名（漢字）（ＳＭＢＣ月次契約Ｆ） */
     zrnitijibrp ,         /* （連携用）一時払保険料 */
     zrngoukeip2 ,         /* （連携用）合計保険料２ */
     zrnzenkizennoup ,         /* （連携用）全期前納保険料 */
     zrntumitatekngk ,         /* （連携用）積立金額 */
     zrntargettktoutatubi ,         /* （連携用）ターゲット到達日 */
     zrnmokuhyouti ,         /* （連携用）目標値 */
     zrnmokuhyoukngk ,         /* （連携用）目標金額 */
     zrnkaiyakuhr ,         /* （連携用）解約返戻金 */
     zrnhrkpjyuutouym ,         /* （連携用）払込保険料充当年月 */
     zrnkihrpruikeigk ,         /* （連携用）既払保険料累計額 */
     zrntousyokykjikawaserate ,         /* （連携用）当初契約時為替レート */
     zrnkykymd ,         /* （連携用）契約年月日 */
     zrnmankiymd ,         /* （連携用）満期年月日 */
     zrnikkatubaraikbn ,         /* （連携用）一括払区分 */
     zrnikkatubaraikaisuu ,         /* （連携用）一括払回数 */
     zrnyobiv56 ,         /* （連携用）予備項目Ｖ５６ */
     zrngmeigyoubijikawaserate ,         /* （連携用）月末営業日時為替レート */
     zrnyobiv16 ,         /* （連携用）予備項目Ｖ１６ */
     zrnsymtymd ,         /* （連携用）消滅年月日 */
     zrngetumatuymdidouw ,         /* （連携用）月末日異動解約返戻金 */
     zrngetumatuymdsibous ,         /* （連携用）月末日死亡保険金 */
     zrnyobiv53           /* （連携用）予備項目Ｖ５３ */
FROM ZT_SmbcGetujiKykMeisaiRn_Z;