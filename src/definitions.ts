export interface NativeARViewerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
