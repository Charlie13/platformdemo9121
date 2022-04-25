// automatically generated by the FlatBuffers compiler, do not modify

package viewer3d.actions.websocketprotocol;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class MessageContent extends Table {
  public static MessageContent getRootAsMessageContent(ByteBuffer _bb) { return getRootAsMessageContent(_bb, new MessageContent()); }
  public static MessageContent getRootAsMessageContent(ByteBuffer _bb, MessageContent obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  public MessageContent __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public HeaderEntry header(int j) { return header(new HeaderEntry(), j); }
  public HeaderEntry header(HeaderEntry obj, int j) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int headerLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }
  public int body(int j) { int o = __offset(6); return o != 0 ? bb.get(__vector(o) + j * 1) & 0xFF : 0; }
  public int bodyLength() { int o = __offset(6); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer bodyAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public ByteBuffer bodyInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 6, 1); }

  public static int createMessageContent(FlatBufferBuilder builder,
      int headerOffset,
      int bodyOffset) {
    builder.startObject(2);
    MessageContent.addBody(builder, bodyOffset);
    MessageContent.addHeader(builder, headerOffset);
    return MessageContent.endMessageContent(builder);
  }

  public static void startMessageContent(FlatBufferBuilder builder) { builder.startObject(2); }
  public static void addHeader(FlatBufferBuilder builder, int headerOffset) { builder.addOffset(0, headerOffset, 0); }
  public static int createHeaderVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startHeaderVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addBody(FlatBufferBuilder builder, int bodyOffset) { builder.addOffset(1, bodyOffset, 0); }
  public static int createBodyVector(FlatBufferBuilder builder, byte[] data) { builder.startVector(1, data.length, 1); for (int i = data.length - 1; i >= 0; i--) builder.addByte(data[i]); return builder.endVector(); }
  public static void startBodyVector(FlatBufferBuilder builder, int numElems) { builder.startVector(1, numElems, 1); }
  public static int endMessageContent(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}

