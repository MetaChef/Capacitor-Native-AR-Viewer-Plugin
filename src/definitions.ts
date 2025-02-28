export interface NativeARViewerPlugin {
  openAR(options: { value: string }): Promise<{ value: string }>;
}
