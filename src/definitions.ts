export interface CapacitorStartIOPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
