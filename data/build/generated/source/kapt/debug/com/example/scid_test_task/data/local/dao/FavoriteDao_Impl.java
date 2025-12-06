package com.example.scid_test_task.data.local.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.example.scid_test_task.data.local.entity.FavoriteEntity;
import java.lang.Class;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class FavoriteDao_Impl implements FavoriteDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<FavoriteEntity> __insertAdapterOfFavoriteEntity;

  public FavoriteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfFavoriteEntity = new EntityInsertAdapter<FavoriteEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `favorites` (`id`,`title`,`price`,`description`,`category`,`image`,`ratingRate`,`ratingCount`,`timestamp`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final FavoriteEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getTitle());
        }
        statement.bindDouble(3, entity.getPrice());
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getDescription());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getCategory());
        }
        if (entity.getImage() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getImage());
        }
        statement.bindDouble(7, entity.getRatingRate());
        statement.bindLong(8, entity.getRatingCount());
        statement.bindLong(9, entity.getTimestamp());
      }
    };
  }

  @Override
  public Object insertFavorite(final FavoriteEntity favorite,
      final Continuation<? super Unit> $completion) {
    if (favorite == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfFavoriteEntity.insert(_connection, favorite);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Flow<List<FavoriteEntity>> getAllFavorites() {
    final String _sql = "SELECT * FROM favorites ORDER BY timestamp DESC";
    return FlowUtil.createFlow(__db, false, new String[] {"favorites"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
        final int _columnIndexOfPrice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "price");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfImage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "image");
        final int _columnIndexOfRatingRate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingRate");
        final int _columnIndexOfRatingCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingCount");
        final int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final List<FavoriteEntity> _result = new ArrayList<FavoriteEntity>();
        while (_stmt.step()) {
          final FavoriteEntity _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final String _tmpTitle;
          if (_stmt.isNull(_columnIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
          }
          final double _tmpPrice;
          _tmpPrice = _stmt.getDouble(_columnIndexOfPrice);
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpImage;
          if (_stmt.isNull(_columnIndexOfImage)) {
            _tmpImage = null;
          } else {
            _tmpImage = _stmt.getText(_columnIndexOfImage);
          }
          final double _tmpRatingRate;
          _tmpRatingRate = _stmt.getDouble(_columnIndexOfRatingRate);
          final int _tmpRatingCount;
          _tmpRatingCount = (int) (_stmt.getLong(_columnIndexOfRatingCount));
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
          _item = new FavoriteEntity(_tmpId,_tmpTitle,_tmpPrice,_tmpDescription,_tmpCategory,_tmpImage,_tmpRatingRate,_tmpRatingCount,_tmpTimestamp);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object getFavoriteById(final int id,
      final Continuation<? super FavoriteEntity> $completion) {
    final String _sql = "SELECT * FROM favorites WHERE id = ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
        final int _columnIndexOfPrice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "price");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfImage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "image");
        final int _columnIndexOfRatingRate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingRate");
        final int _columnIndexOfRatingCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingCount");
        final int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final FavoriteEntity _result;
        if (_stmt.step()) {
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final String _tmpTitle;
          if (_stmt.isNull(_columnIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
          }
          final double _tmpPrice;
          _tmpPrice = _stmt.getDouble(_columnIndexOfPrice);
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpImage;
          if (_stmt.isNull(_columnIndexOfImage)) {
            _tmpImage = null;
          } else {
            _tmpImage = _stmt.getText(_columnIndexOfImage);
          }
          final double _tmpRatingRate;
          _tmpRatingRate = _stmt.getDouble(_columnIndexOfRatingRate);
          final int _tmpRatingCount;
          _tmpRatingCount = (int) (_stmt.getLong(_columnIndexOfRatingCount));
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
          _result = new FavoriteEntity(_tmpId,_tmpTitle,_tmpPrice,_tmpDescription,_tmpCategory,_tmpImage,_tmpRatingRate,_tmpRatingCount,_tmpTimestamp);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object deleteFavorite(final int id, final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM favorites WHERE id = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
